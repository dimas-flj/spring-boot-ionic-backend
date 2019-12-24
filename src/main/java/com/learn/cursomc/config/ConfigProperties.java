package com.learn.cursomc.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import com.learn.cursomc.utils.Util;

public class ConfigProperties {
	private static final Logger log = LoggerFactory.getLogger(ConfigProperties.class);
	private static Properties prop;
	
	private static ConfigProperties config;
	
	public static ConfigProperties getInstance() {
		try {
			if (Util.isNull(config)) {
				config = new ConfigProperties();
			}
		}
		catch(IOException e) {
			log.error("Erro ao abrir arquivo de configuração.", e);
		}
		return config;
	}
	
	private ConfigProperties() throws IOException {
		if (Util.isNull(prop)) {
			try {
				prop = new Properties();
				
				InputStream resourceAsStream = ConfigProperties.class.getClassLoader().getResourceAsStream("application.properties");
				prop.load(resourceAsStream);
			}
			catch(IOException e) {
				throw new IOException("Erro ao obter propriedades.");
			}
		}
	}
	
	@Bean
	public String getValue(String sWiredValue, String nm_prop) {
		String sOutValue = sWiredValue;
		if (!Util.isValidString(sWiredValue)) {
			sOutValue = prop.getProperty(nm_prop);
			log.info("Obtendo propriedade do arquivo de propriedades - nome(" + nm_prop + ") - valor(" + sOutValue + ")");
		}
		else {
			log.info("Não vai obter propriedade do arquivo de propriedades - nome(" + nm_prop + ") - valor(" + sOutValue + ")");
		}
		return sOutValue;
	}
}