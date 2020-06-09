package heaps;

public class InsertionInHeap {
	
	private int[] heap;
	private int size;
	public int getSize() {
		return size;
	}
		
		
	public InsertionInHeap(int capacity) {
			heap=new int[capacity];
		}
	
	public void insert(int value) {
		if(isFull(size)) {
			throw new IndexOutOfBoundsException("heap is full"); 
		}
		
		heap[size]=value;
		reseizeHeap(size);
		size++;
		for(int i=0;i<heap.length;i++) {
			System.out.println(heap[i]);
		}
		
	}
	
	public int deletion(int index) {
		if(isFull(index)) {
			throw new IndexOutOfBoundsException();
		}
		 int parent=getParentIndex(index);
		 int deletedNode=heap[index];
		 heap[index]=heap[size-1];
		 
		 
		 if(index==0 || heap[index]<heap[parent]) {
			 fixBelowHeap(index, size-1);
		 }else {
			 fixAboveHeap(index);
		 }
		size--;
		return deletedNode;
	}
	
	
	public void fixBelowHeap(int index, int lastHeapIndex) {
		int childToSwap;
		while(index<=lastHeapIndex) {
			int leftchild=getChild(index, true);
			int rightchild=getChild(index, false);
			
			if(leftchild <= lastHeapIndex) {
				if(rightchild>lastHeapIndex) {
					childToSwap=leftchild;
				}else {
					childToSwap= (heap[leftchild] > rightchild) ? leftchild :rightchild;
					
				}
			
			if(heap[index]< heap[childToSwap]) {
				
				int temp=heap[index];
				heap[index]=heap[childToSwap];
				heap[childToSwap]=temp;
			}else {
				break;
			}
			index=childToSwap;
			
			
			
		}
			else {
				break;
			}
	}
	}
	public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

	
	
	public void fixAboveHeap(int index) {
		 int newValue = heap[index];
	        while (index > 0 && newValue > heap[getParentIndex(index)]) {
	            heap[index] = heap[getParentIndex(index)];
	            index = getParentIndex(index);
	        }

	        heap[index] = newValue;
	}
	
	public void reseizeHeap(int index) {
		int newValue=heap[index];
		while(index>0 && newValue > heap[getParentIndex(index)]) {
			heap[index]=heap[getParentIndex(index)];
			index=getParentIndex(index);
		}
		
		heap[index]=newValue;
	}
	
	public int getParentIndex(int index) {
		return (index-1)/2;
	}
	
	public boolean isFull(int size) {
		return size==heap.length;
	}
	
	
	 public int getChild(int index, boolean left) {
	        return 2 * index + (left ? 1 : 2);
	    }
	
	}

