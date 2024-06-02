package heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

	private List<Integer> heap;
	
	public MinHeap() {
		heap = new ArrayList<>();
	}
	
	public void insert(int val) {
		heap.add(val);
		int index = heap.size() - 1;
		heapifyUp(index);
	}
	
	public int deleteMin() {
		if (heap.isEmpty())
			throw new IllegalStateException("Heap is empty");
		int min = heap.get(0);
		int last = heap.remove(heap.size() - 1);
	
		if (!heap.isEmpty()) {
			heap.set(0, last);
			heapifyDown(0);
		}
	
		return min;
	}
	
	public int getMin() {
		if (heap.isEmpty())
			throw new IllegalStateException("Heap is empty");
		
		return heap.get(0);
	}
	
	private void heapifyUp(int index) {
		int parent = (index - 1) / 2;
		if (index > 0 && heap.get(index) < heap.get(parent)) {
				swap(index, parent);
				heapifyUp(parent);
		}
	}
	
	private void heapifyDown(int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int smallest = index;
	
		if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
			smallest = left;
		}
	
		if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
			smallest = right;
		}
	
		if (smallest != index) {
			swap(index, smallest);
			heapifyDown(smallest);
		}
	}
	
	private void swap(int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	public static void main(String[] args) {
		MinHeap heap = new MinHeap();
		heap.insert(3);
		heap.insert(1);
		heap.insert(4);
		heap.insert(1);
		heap.insert(5);
		heap.insert(9);
	
		System.out.println("Minimum element: " + heap.getMin());
		System.out.println("Deleted minimum element: " + heap.deleteMin());
		System.out.println("Minimum element after deletion: " + 
	heap.getMin());
	}

}
