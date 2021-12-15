package com.avaliacao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.avaliacao.model.Template;

/**
 * JDBC case model in Srping 
 * @author Jose
 *
 */
@Repository
public class JdbcTemplateRepository implements TemplateRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Template template) {		
		return jdbcTemplate.update("INSERT INTO template (name, type) VALUES (?, ?)",
				new Object[] {template.getName(), template.getType()});
	}

	@Override
	public int update(Template template) {
		return jdbcTemplate.update("UPDATE template SET name=?, type=? WHERE id=?",
				new Object[] {template.getName(), template.getType(), template.getId()});
	}

	@Override
	public Template findById(Long id) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM template WHERE id=?",
					BeanPropertyRowMapper.newInstance(Template.class), id);
		} catch (IncorrectResultSizeDataAccessException e) {
			e.printStackTrace();
			return null; // :..-(
		}
	}

	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("DELETE FROM template WHERE id=?",
				id);
	}

	@Override
	public List<Template> findAll() {
		return jdbcTemplate.query("SELECT * FROM template", BeanPropertyRowMapper.newInstance(Template.class));
	}

	@Override
	public List<Template> listByName(String name) {
		String s = "SELECT * FROM template WHERE nome LIKE '%"+name+"%' collate binary_ci";
		return jdbcTemplate.query(s, BeanPropertyRowMapper.newInstance(Template.class));
	}
	
}
