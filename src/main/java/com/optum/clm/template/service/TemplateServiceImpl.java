package com.optum.ct.template.service;

import org.springframework.stereotype.Service;

import com.optum.ct.template.model.TemplateModel;

/**
 * Example service class. A service encapsulates stateless functionality, and provides an interface for business logic.
 * This is a simple example for an annotated service class.
 */
@Service
public class TemplateServiceImpl implements TemplateService {

	@Override
	public TemplateModel findById(Long id) {
		TemplateModel model = new TemplateModel();
		model.setId(id);
		return model;
	}

    @Override
    public void save(TemplateModel model) {
		// Persist the TemplateModel object.
    }

}
