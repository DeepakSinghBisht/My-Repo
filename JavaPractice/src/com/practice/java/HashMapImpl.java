package com.practice.java;

public class HashMapImpl<K,V> {

// 2. Create array of Objects that will store Entry class
// 3. Create capacity to identify index and size of bucket
	private EntryImp<K,V>[] bucket;
	private static final int capacity=16;
	private int size=0;

// 4. Create a default size bucket
	HashMapImpl(){
		this(capacity);
	}
// 5. Create a bucket of user defined size
	HashMapImpl(int capacity){
		this.bucket = new EntryImp[capacity];
	}
	
	public void put(K key, V value) {
		EntryImp<K,V> entry = new EntryImp<K,V>(key, value, null);
		
		if(key == null) {
			bucket[0] = entry;
			return;
		}
// 6. Calculate index where entry object will be stored		
		int index = key.hashCode()% bucket.length;
// 7. If bucket is null then store entry object at that index
		EntryImp<K,V> existing = bucket[index];
		if(existing == null) {
			bucket[index] = entry;
			size++;
		}else {
// 8. If bucket is not null, check till the last object in linked list whether any key is equal to our key. If it is there then replace the value
			while(existing.next != null) {
				if(existing.key.equals(entry.key)) {
					existing.value = entry.value;
					return;
				}
				existing = existing.next;	
			}
// 9. After the last loop existing will have last object in the linked list, compare its key and if equal to current key, replace the value
			if(existing.key.equals(entry.key))
				existing.value = entry.value;
			else
// 10. Set next of existing object in linked list as our current object
				existing.next = entry;
				size++;
				
		}
	}
	
	
	public V get(K key) {
		if(key == null)
			if(this.bucket[0] == null) {
				return bucket[0].value;
			}else {
				System.out.println("Element doesn't exists in the Map");
				return null;
			}
		else {
			int index = key.hashCode()%this.bucket.length;
			
			EntryImp<K,V> existing = bucket[index];
			if(existing == null) {
				System.out.println("Element doesn't exist in the map");
				return null;
			}else {
				while(existing.next != null) {
					if(existing.key.equals(key))
						return existing.value;
					existing = existing.next;
				}
				if(existing.key.equals(key))
					return existing.value;
				else
					System.out.println("Element doesn't exists in the Map");
					return null;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMapImpl obj = new HashMapImpl<>();
		obj.put(1, "Deepak");
		obj.put(2, "Swati");
		obj.put(3, "Devki");
		obj.put(4, "Anand");
		obj.put(5, "Neelam");
		
		System.out.println(obj.get(1));
		System.out.println(obj.get(2));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));
		System.out.println(obj.get(5));
		String X=null;
		System.out.println(X);
	}

}

// 1. Create an Entry class which will be Node of Linked List
class EntryImp<K,V>{
	final K key;
	V value;
	EntryImp<K,V> next;
	
	EntryImp(K key, V value, EntryImp<K,V> next){
		this.key = key;
		this.value = value;
		this.next = next;
	}
}