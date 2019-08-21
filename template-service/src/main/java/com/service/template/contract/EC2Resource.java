package com.service.template.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EC2Resource {
	private String keyName;
	private String vpcId;
	private String subnetId;
	private String instanceType;
}
