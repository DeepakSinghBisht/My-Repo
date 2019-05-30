package com.practice.java;

public class MergeNames {
    
    /*public static String[] uniqueNames(String[] names1, String[] names2) {
    	String result[];
    	Boolean isBig;
    	if(names1.length > names2.length) {
    		result = new String[names1.length];
    		isBig = true;
    		
    		for(int i=0; i<names1.length; i++) {
        		if()
    			result[i] = names1[i];
        	}
    		
    	}
    	else {
    		result = new String[names2.length];
    	}
    		
    	
    	
    	
        throw new UnsupportedOperationException("Waiting to be implemented.");
    	
    }*/
    interface TestInterface{
    	void display();
    	default void show() {
    		
    	}
    }

    void testLamda(TestInterface obj) {
    	obj.display();
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
//        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
        
        TestInterface obj1 = () -> System.out.println("Hello Lambda");
        
        MergeNames obj = new MergeNames();
        obj.testLamda(obj1);
    }
}