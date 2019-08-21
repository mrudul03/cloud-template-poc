package com.service.template.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateResource {

	private String templateName;
	private String templatePath;
	private String environmentName;
	private int ec2Count;
	private int s3Count;
	private EC2Resource ec2Resource;
	private S3Resource s3Resource;
}
