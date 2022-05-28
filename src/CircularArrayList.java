
public class CircularArrayList<T> implements ArrayListADT<T>{
	
	int capacity;
	int size;
	int front;
	int rear;
	T[] arrayList;
	
	@SuppressWarnings("unchecked")
	public CircularArrayList() {
		//Fill in the constructor for the circularArrayList
		this.capacity = 100;
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.arrayList = (T[])(new Object[capacity]);
		
	}
	
	@SuppressWarnings("unchecked")
	public CircularArrayList(int initialCapacity) {
		//Fill in the constructor for the circularArrayList
		this.capacity = initialCapacity;
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.arrayList = (T[])(new Object[capacity]);
		
	}

	//helper method expandCapacity
	@SuppressWarnings("unchecked")
	private void expandCapacity() {
		// TODO Auto-generated method stub
		 
		T[] oldArray = this.arrayList.clone();
		T[] newArray = (T[]) new Object[this.capacity * 2];
		
		for(int i = 0; i < this.size; i++) {
			newArray[i] = oldArray[this.indexFor(i)];
		}
		this.arrayList = newArray;
		this.front = 0;
	
	/*	
		int currentCapacity = this.arrayList.length;
		if(this.size < currentCapacity) {
			return;
		}
		
		else {
			this.arrayList = (T[])(new Object[capacity * 2]);
		}
		*/
	}
	
	//helper method
	private int indexFor(int index) {
	    int toReturn = (this.front + index) % this.arrayList.length;
	    return toReturn;
	  }
	
	
	@Override
	public void addRear(T element) {
		//Method to add element at the rear of the arraylist
		if(this.size >= arrayList.length) {
			expandCapacity();
		}
	    
		if(this.size == 0) {
			this.arrayList[this.rear] = element;
			size++;
		}
		
		else {
			expandCapacity();
			this.arrayList[this.indexFor(this.size)] = element;
			size++;
		}
	}


	@Override
	public void addFront(T element) {
		//Method to add element at the front of the arraylist i.e. towards start
		if(this.size >= arrayList.length) {
			expandCapacity();
		}
		
		
		else {
			this.size += 1;
			this.front -= 1;
			if(this.front == -1) {
				this.front = this.arrayList.length -1;
			}
			this.arrayList[this.front] = element;
			//size++;
		}
	}

	public T get(int index) throws Exception {
		//Method to get element at a given index of the circularArrayList
		if(index < 0) {
			throw new Exception("the index is not in bound");
		}
		
		if(index > this.size) {
			throw new Exception("the index is out of bound");
		}
		
		
		int toReturn = this.indexFor(index);
		return this.arrayList[toReturn];
		
	}
	
	public void up(int index) {
		int i = index -1;
		for(int j = i; j > 0; j -= 1) {
			this.arrayList[indexFor(j + 1)] = this.arrayList[indexFor(j)];
		}
	}
	
	
	public void down(int index) {
		int i = index;
		for(int j = i; j < this.size; j += 1) {
			this.arrayList[indexFor(j)] = this.arrayList[indexFor(j + 1)];
		}
	}


	@Override
	public T remove() {
		//Method to remove the element from the front
		T toRemove = arrayList[this.front];
		
		if(this.size == 0) {
			return null;
		}
		
		else {
			int removeIndex = this.front;
			
			if(removeIndex > (this.size /2)) {
				down(removeIndex);
			}
			
			else {
				up(removeIndex);
				this.front = indexFor(1);
				
			}
			
			
		//	T toRemove = arrayList[this.front];
			size--;
			return toRemove;
		}
		
	}
	
	@Override
	public int getSize() {
		return this.size;
	}
	
	@Override
	public int getRear() {
		return this.rear;
	}
	
	@Override
	public int getFront() {
		return this.front;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
}
