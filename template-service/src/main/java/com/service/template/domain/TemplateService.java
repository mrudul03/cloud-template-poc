package com.service.template.domain;

import java.io.File;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.hubspot.jinjava.Jinjava;
import com.service.template.contract.TemplateResource;

@Service
public class TemplateService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateService.class);
	
	public String createTemplate(TemplateResource templateResource){
		String renderedTemplate = null;
		
		try {
			Jinjava jinjava = new Jinjava();
			Map<String, Object> context = Maps.newHashMap();
			context.put("environmentName", templateResource.getEnvironmentName());
			context.put("ec2count", 4);
			context.put("s3count", templateResource.getS3Count());
			context.put("keyName", templateResource.getEc2Resource().getKeyName());
			context.put("instanceType", templateResource.getEc2Resource().getInstanceType());
			context.put("subnetId", templateResource.getEc2Resource().getSubnetId());
	
			String fileName = templateResource.getTemplatePath()+templateResource.getTemplateName();
			File file = new File(fileName);
			String templateContent = Files.toString(file, Charsets.UTF_8);
	
			renderedTemplate = jinjava.render(templateContent, context);
			LOGGER.info(renderedTemplate);
			
		}
		catch(Exception e){
			LOGGER.error("Error in createTemplate", e);
		}
		
		return renderedTemplate;
	}

}
