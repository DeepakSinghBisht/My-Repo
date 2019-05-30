package com.practice.java;

import java.io.*;
import java.util.*;

public class RepeatedString {
	
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long acount = 0;
    	long bcount = 0;
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i) == 'a')
        		acount++;
        }
        if(acount > 0) {
            bcount = ((n/s.length())*acount);
        }else
        	bcount = 0;
        
        for(int i=0;i<(n%(s.length()));i++) {
        	if(s.charAt(i) == 'a')
        		bcount++;
        }
        
        return bcount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);
        scanner.close();
    }

}
