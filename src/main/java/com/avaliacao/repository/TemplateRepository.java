package com.avaliacao.repository;

import java.util.List;

import com.avaliacao.model.Template;

/**
 * Model case use
 * @author Jose
 *
 */
public interface TemplateRepository {
	int save (Template template);
	
	int update (Template template);
	
	Template findById(Long id);
	
	int delete (Long id);
	
	List<Template> findAll();
	
	List<Template> listByName(String name);
}
