package com.practice.java;

public class LinkedListImpl {
	Node head;
	
	public static LinkedListImpl insert(int data,LinkedListImpl list) {
		Node newNode = new Node(data);
		
		if(list.head == null)
			list.head = newNode;
		else {
			Node last = list.head;
			while(last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}
	
	public static void printList(LinkedListImpl list) {
			Node current = list.head;
			while(current != null) {
				System.out.println(current.data);
				current = current.next;
			}
		}
	
	public static LinkedListImpl deleteByKey(LinkedListImpl list, int data) {
		Node current = list.head;
		Node previous = null;
		
		if(current != null && current.data == data) {
			list.head = current.next;
			return list;
		}
		while(current != null && current.data != data) {
			previous = current;
			current = current.next;
		}
		if(current != null) {
			previous.next = current.next;
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListImpl list = new LinkedListImpl();
		
		list = insert(10,list);
		list = insert(20,list);
		list = insert(30,list);
		list = insert(40,list);
		list = insert(50,list);
		list = insert(60,list);
		list = insert(70,list);
		
		printList(list);
	}

}

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data=data;
		this.next=null;
	}
}