package com.practice.java;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValley {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    	int count=0;
    	int currentLevel=0;
    	
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i) == 'U') {
    			currentLevel++;
    			if(currentLevel == 0)
    				count++;
    		}
    		else
    			currentLevel--;
    	}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        System.out.println(result);

        scanner.close();
    }

}
