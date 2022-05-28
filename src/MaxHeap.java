
import java.util.*;

public class MaxHeap<K, V> {

List<HeapEntry<K,V>> entries;
int capacity;
int heapSize = 0;
Comparator comparator;

    public MaxHeap(int capacity, Comparator comparator){
        // Constructor for the max heap
		this.entries = new ArrayList<>();
		this.capacity = capacity;
		this.comparator = comparator;

       
    }
	//helper swap method
	private void swap(HeapEntry<K, V> x, HeapEntry<K, V> y) {
		HeapEntry<K, V> temp = x;
		x = y;
		y = temp;
	}
	//helper bubble up
	private void bubbleUp(HeapEntry<K,V> entry) {
		int index = entries.indexOf(entry);
		int ParentIndex = (index-1)/2;
		if (index <= 0) {
			return;
		}
		HeapEntry<K,V> parent = entries.get(ParentIndex);
		int comp = this.comparator.compare(entry.getValue(),parent.getValue());
		if (comp > 0) {
			swap(entry,parent);
			bubbleUp(parent);
		}
		else {
			return;
		}
		
	}
	//helper bubbledown
	private void bubbleDown(HeapEntry<K,V> entry) {
		int Lastindex = entries.size()-1;
		HeapEntry<K,V> lastEntry = entries.get(Lastindex);
		swap(entry,lastEntry);
		entries.remove(lastEntry);

		int index = entries.indexOf(entry);
		int LchildIndex = 2*index +1;
		HeapEntry<K,V> leftchild = entries.get(LchildIndex);
		int RchildIndex = 2*index +2;
		HeapEntry<K,V> rightchild = entries.get(RchildIndex);

		int comp = comparator.compare(leftchild.key,rightchild.key);
		
		while (comp != 0) {
			if (comp > 0) {
				swap(leftchild,entry);
				bubbleDown(leftchild);
			}
			else if (comp < 0) {
				swap(rightchild,entry);
				bubbleDown(rightchild);
			}
		}
		
	}


	public void add(K key, V value){
	    // Method to add the key value pair in the heap, remember to satisfy max heap Property
		HeapEntry<K,V> entry = new HeapEntry(key, value);
		if(entries.isEmpty()) {
			entries.add(entry);
			heapSize+=1;
		}

		else if (!entries.isEmpty()){
			entries.add(entry);
			bubbleUp(entry);
			heapSize +=1;
		}
	}
	
	public HeapEntry<K,V> peek() {
		// Method to return the max element in the heap
		if(entries.isEmpty()) {
			return null;
		}
		else {
			return entries.get(0);
		}
	}
	
	public HeapEntry<K,V> remove() {
		//Method to remove the max element in the heap, remember to satisfy max heap Property
		HeapEntry<K,V> max = peek();
		if (entries.isEmpty()) {
			return null;
		}
		else {
			bubbleDown(entries.get(0));
		}
		return max;
	}
	
}

class HeapEntry<K, V> implements DefaultMap.Entry<K,V>{
	K key;
	V value;

	HeapEntry(K key, V value){
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}

	public void setValue(V value){
		this.value = value;
	}
}