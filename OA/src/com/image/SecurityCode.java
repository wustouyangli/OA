package com.image;

public class SecurityCode {
	public static String getSecurityCode(){
		return getSecurityCode(4);
	}
	public static String getSecurityCode(int length){
		char[] codes = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',  
                'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p',  
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',  
                'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',  
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		char[] res = new char[length];
		int n = codes.length;
		for (int i = 0; i < length; i++){
			int p = (int)(Math.random() * n);
			p %= n;
			res[i] = codes[p];
		}
		return String.valueOf(res);
	}
}
