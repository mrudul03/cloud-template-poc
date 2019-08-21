package com.service.template.controller;

import java.io.ByteArrayInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;
import com.service.template.contract.TemplateResource;
import com.service.template.domain.TemplateService;

@RestController
@RequestMapping(value="/api/template-service")
public class TemplateController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);
	
	@Autowired
	private TemplateService templateService;
	
	@RequestMapping(value="/templates", 
			method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> createTemplate(@RequestBody TemplateResource templateResource){
		
		LOGGER.info(templateResource.toString());
		String contentType = "application/octet-stream";
		String templateName = templateResource.getTemplateName()+"-"+templateResource.getEnvironmentName()+".yml";
		
		String renderedTemplate = templateService.createTemplate(templateResource);
		InputStreamResource inputStreamResource = new InputStreamResource(
				new ByteArrayInputStream(renderedTemplate.getBytes()));
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+templateName+"\"")
				.body(inputStreamResource);
	}

}
