package com.practice.java;

import java.util.*;

import jdk.jshell.execution.Util;

public class MergeCollections {
	String colName;
	String newWeight;
	String oldWeight;
	private MergeCollections localObj;
	
	public MergeCollections(String colName, String newWeight, String oldWeight) {
		this.colName = colName;
		this.oldWeight= oldWeight;
		this.newWeight= newWeight;
	}

	public MergeCollections(MergeCollections obj1) {
		// TODO Auto-generated constructor stub
		this.colName = obj1.colName;
		this.newWeight = obj1.newWeight;
		this.oldWeight = obj1.oldWeight;
	}

	private static void finalCollection(Set<MergeCollections> s1, Set<MergeCollections> s2) {
		// TODO Auto-generated method stub
		Map<String,MergeCollections> finalSet = new HashMap<String,MergeCollections>();
		for(MergeCollections s: s1) {
			if(!finalSet.containsKey(s.colName)) {
				MergeCollections mergedWeight = new MergeCollections(s.colName,s.newWeight,s.oldWeight);
				finalSet.put(s.colName, mergedWeight);
			}
		}
		for(MergeCollections s: s2) {
			if(!finalSet.containsKey(s.colName)) {
				MergeCollections mergedWeight = new MergeCollections(s.colName,s.newWeight,"");
				finalSet.put(s.colName, mergedWeight);
			}else {
				MergeCollections mergedWeight = new MergeCollections(s.colName,"",s.oldWeight);
				finalSet.put(s.colName, mergedWeight);
			}
		}
		
		System.out.println(finalSet);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeCollections obj1 = new MergeCollections("col1", "50Kg","");
		MergeCollections obj2 = new MergeCollections("col3", "70Kg","");
		MergeCollections obj3 = new MergeCollections("col4", "90Kg","");
		MergeCollections obj4 = new MergeCollections("col1", "60Kg","");
		MergeCollections obj5 = new MergeCollections("col2", "20Kg","");
		MergeCollections obj6 = new MergeCollections("col4", "10Kg","");
		MergeCollections obj7 = new MergeCollections("col5", "100Kg","");
		
		Set<MergeCollections> s1 = new HashSet<MergeCollections>();
		Set<MergeCollections> s2 = new HashSet<MergeCollections>();
		s1.add(obj1);s1.add(obj2);s1.add(obj3);
		s2.add(obj4);s2.add(obj5);s2.add(obj6);s2.add(obj7);
		
		finalCollection(s1,s2);
		MergeCollections cloneObj = testCol(obj1);
		cloneObj.colName="Modified";
		System.out.println(obj1.colName);
	}

	private static MergeCollections testCol(MergeCollections obj1) {
		// TODO Auto-generated method stub
		return new MergeCollections(obj1);
	}

}
