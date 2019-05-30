package com.practice.java;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SocksPair {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();
    	int count=0;
    	for(int i=0;i<n;i++) {
    		if(myMap.get(ar[i]) != null) {
    			myMap.put(ar[i], myMap.get(ar[i])+1);
    		}else {
    			myMap.put(ar[i], 1);
    		}
    	}
    	
    	for(Map.Entry<Integer, Integer> entry: myMap.entrySet()) {
    		count = count + entry.getValue()/2;
    	}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        @SuppressWarnings("unused")
		int result = sockMerchant(n, ar);
        System.out.println(result);


        scanner.close();
    }

}

