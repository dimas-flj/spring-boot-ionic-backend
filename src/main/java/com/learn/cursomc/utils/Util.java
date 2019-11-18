package com.learn.cursomc.utils;

public class Util {
	/**
	 * Verifica se um dado objeto é nulo
	 * 
	 * @param dado
	 *        Dado a ser validado.
	 * @return Retorna <i>true</i> se o objeto é nulo.
	 */
	public static boolean isNull(Object dado) {
		if (dado == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica se uma string é válida: não nula e diferente de vazio e brancos.
	 * 
	 * @param obj
	 *        Objeto representando a string a ser validada.
	 * @return Retorna <i>true</i> se o objeto é nulo.
	 */
	public static boolean isValidString(Object obj) {
		if (!isNull(obj)) {
			if (obj.toString().trim().length() > 0) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Valida uma string numérica. Se apenas um caracter da string não for um dígito válido, o teste falha.
	 * 
	 * @param obj
	 *        String a ser validada.
	 * @return True se a string tiver apenas dígitos válidos
	 */
	public static boolean isNumerico(Object obj) {
		if (!isValidString(obj)) {
			return false;
		}
		
		String s = obj.toString();
		try {
			if (s.startsWith("-")) {
				s = s.substring(s.indexOf("-") + 1).trim();
			}
			if (s.startsWith("+")) {
				s = s.substring(s.indexOf("+") + 1).trim();
			}
			
			Float.parseFloat(s);
		}
		catch (Exception e) {
			return false;
		}
		
		return true;
	}
}