package com.learn.cursomc.utils;

import java.util.HashMap;
import java.util.Map;

public class Constantes {
	public Map<String, Object> propriedades;
	
	public Constantes() {
		propriedades = new HashMap<String, Object>();
		populaPropriedades();
	}
	
	private void populaPropriedades() {
		propriedades.put("mail_sender", "");
		propriedades.put("mail_recipient", "");
		propriedades.put("jwt_secret", "");
		propriedades.put("jwt_expiration", Long.parseLong("0"));
		propriedades.put("aws_access_key", "");
		propriedades.put("aws_secret_access_key", "");
		propriedades.put("s3_bucket", "");
		propriedades.put("s3_region", "");
		propriedades.put("img_prefix_profile", "");
		propriedades.put("img_profile_size", Integer.parseInt("0", 10));
	}
	
	public Object getPropriedade(String chave) {
		return propriedades.get(chave); 
	}
}