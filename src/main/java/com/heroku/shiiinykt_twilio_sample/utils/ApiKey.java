package com.heroku.shiiinykt_twilio_sample.utils;

import org.yaml.snakeyaml.Yaml;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ApiKey {
	@Getter @Setter
	private String sid;
	@Getter @Setter
	private String seclet;
	
	public static ApiKey get() {
		return new Yaml().loadAs(ClassLoader.getSystemResourceAsStream("yaml/apiKey.yaml"), ApiKey.class);
	}
}
