package com.practice.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MovingTotal {
    // Store the elements added in order
    private List<Integer> elements = new ArrayList<>();
    int size,index=0;

    // Map form the sum to the index(es) that sum up to that number
    private Map<Integer, List<Integer>> elementIndex;
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void append(int[] list) {
    	for(int i=0;i<list.length;i++) {
    		elements.add(list[i]);
    	}
    	size = elements.size();
    	if(size >= 3) {
    		int sum = elements.get(size-3)+elements.get(size-2)+elements.get(size-1);
    		elementIndex.computeIfAbsent(sum, k -> new LinkedList<>()).add(size - 3);
    	}
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
    	 List<Integer> myList= Collections.unmodifiableList(
    			 elementIndex.getOrDefault(total, Collections.emptyList()));
    	return (myList == null);
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));

        movingTotal.append(new int[] { 4 });

        System.out.println(movingTotal.contains(9));
    }
}