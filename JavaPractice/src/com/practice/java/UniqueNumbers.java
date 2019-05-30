package com.practice.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class UniqueNumbers {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
    	Map<Integer,Integer> myMap = new HashMap<Integer, Integer>();
    	List<Integer> myList = new ArrayList<Integer>();
    	for(int number : numbers) {
    		if(myMap.containsKey(number))
    			myMap.put(number, myMap.get(number)+1);
    		else
    			myMap.put(number, 1);
    	}
    	
    		for (Map.Entry<Integer,Integer> entry : myMap.entrySet()) {
    			if(entry.getValue() == 1) {
    				myList.add(entry.getKey());
    			}
    		}
    		return myList;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}