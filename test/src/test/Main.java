package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class Main {
	public static void main(String args[]) {
	String x = "welcome to the programming";
	
	for (int i = 1, len = x.length(); i <= len; i++) {
	    char ch = x.charAt(i);
	    if (i % 2 == 0) {
	        System.out.print(Character.toUpperCase(ch));
	    } else {
	    	 System.out.print(Character.toLowerCase(ch));
	    }
	}
	System.out.println();
   

}
}
