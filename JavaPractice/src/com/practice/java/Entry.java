package com.practice.java;

public class Entry {
	
	int front, size=0; 
    int  capacity=10; 
    int rear = 9;
    String array[]= new String[10];; 
       
    
    
    public void enter(String passportNumber) {
        this.rear = (this.rear + 1); 
        this.array[this.rear] = passportNumber; 
        this.size = this.size + 1; 
        System.out.println(passportNumber+ " enqueued to queue"); 
    }

    public String leave() {
         String item = this.array[this.front]; 
         this.front = (this.front + 1); 
         this.size = this.size - 1; 
         return item;
    }
    
    public static void main(String[] args) {
        Entry entry = new Entry();
        entry.enter("AB54321");
        entry.enter("UK32032");
        System.out.println(entry.leave());
        System.out.println(entry.leave());
    }
}