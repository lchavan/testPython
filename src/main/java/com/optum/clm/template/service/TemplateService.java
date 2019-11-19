package com.optum.ct.template.service;

import com.optum.ct.template.model.TemplateModel;

public interface TemplateService {

	TemplateModel findById(Long id);

	void save(TemplateModel model);
}
