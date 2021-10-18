package controller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator{

	Pattern pat;
	Matcher mat;
	String pattern;

	public InputValidator(){}

	public boolean isEmpty(String paramStr){
		try {
			return paramStr.isEmpty();
		} catch (Exception e) {
			if(paramStr == null) {
				return true;
			}else {
				return false;
			}
		}
		
	}

	public boolean hasIllegalCharacters(String paramStr){
		if(this.isEmpty(paramStr)){
			return false;
		}

		pattern = "[;'`%!.*_]";
		pat = Pattern.compile(pattern);
		mat = pat.matcher(paramStr);

		return mat.find();
	}

	public boolean isAlphabetic(String paramStr){
		if(this.isEmpty(paramStr)){
			return false;
		}

		char[] tempInput = paramStr.toCharArray();

		for(char c: tempInput){
			if(Character.isDigit(c)){
				return false;
			}
		}

		pattern = "[a-zA-Z]";
		pat = Pattern.compile(pattern);
		mat = pat.matcher(paramStr);

		return mat.find();
	}

	public boolean isNumeric(String paramStr){
		if(this.isEmpty(paramStr)){
			return false;
		}

		char[] tempInput = paramStr.toCharArray();

		for(char c: tempInput){
			if(Character.isAlphabetic(c)){
				return false;
			}
		}

		pattern = "[\\d]";
		pat = Pattern.compile(pattern);
		mat = pat.matcher(paramStr);

		return mat.find();
	}

	public boolean isAlphanumeric(String paramStr){
		if(this.isEmpty(paramStr)){
			return false;
		}

		pattern = "[\\w]";
		pat = Pattern.compile(pattern);
		mat = pat.matcher(paramStr);

		return mat.find();
	}
	
	public boolean overlapsCharLimit(String paramStr,int paramLimit) {
		if(this.isEmpty(paramStr)){
			return false;
		}
		
		if(paramStr.length() > paramLimit) {
			return true;
		}
		return false;
	}
	
	public boolean underlapsCharLimit(String paramStr,int paramLimit) {
		if(this.isEmpty(paramStr)){
			return false;
		}
		
		if(paramStr.length() < paramLimit) {
			return true;
		}
		return false;
	}
	
	public boolean hasWhitespaces(String paramStr) {
		if(this.isEmpty(paramStr)){
			return false;
		}
		
		pattern = "[\\s]";
		pat = Pattern.compile(pattern);
		mat = pat.matcher(paramStr);
		
		return mat.find();
	}
	
	public boolean invalidEmailCharacters(String paramStr){
		if(this.isEmpty(paramStr)){
			return false;
		}

		pattern = "[;'`%!*]";
		pat = Pattern.compile(pattern);
		mat = pat.matcher(paramStr);

		return mat.find();
	}
	
	public boolean invalidHostCharacters(String paramStr){
		if(this.isEmpty(paramStr)){
			return false;
		}

		pattern = "[;@'`%!*]";
		pat = Pattern.compile(pattern);
		mat = pat.matcher(paramStr);

		return mat.find();
	}
	
	public boolean invalidPortCharacters(String paramStr) {
		
		if(this.hasWhitespaces(paramStr)) {
			return false;
		}
		
		if(this.isNumeric(paramStr)) {
			return false;
		}
		
		if(this.hasIllegalCharacters(paramStr)) {
			return false;
		}
		
		return true;
	}
	
	public boolean invalidFileName(String paramStr){
		if(this.isEmpty(paramStr)){
			return false;
		}

		pattern = "[;'`%!*/<>:.\"|?*]";
		pat = Pattern.compile(pattern);
		mat = pat.matcher(paramStr);

		return mat.find();
	}

}