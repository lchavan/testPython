package com.optum.ct.template.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optum.ct.template.model.TemplateModel;
import com.optum.ct.template.service.TemplateService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Example Spring REST controller. Provides annotation driven REST endpoints, parameter type conversions are provided
 * provided by built-in Spring converters.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/template")
public class TemplateController {

    /**
     * Injected stateless service.
     */
    private final TemplateService service;

    /**
     * Example GET endpoint.
     *
     * @param id A model id.
     * @return Model instance is converted to JSON by built-in converters.
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TemplateModel findById(@PathVariable Long id) {

        return service.findById(id);
    }

    /**
     * Example POST endpoint.
     *
     * @param model A model object parsed from JSON by built-in converters.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody TemplateModel model) {
        service.save(model);
    }
}
