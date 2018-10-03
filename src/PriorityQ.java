

import java.util.Comparator;


public class PriorityQ {
	public int cap, place, heap_size, parent, child;
	public Node[] heap;
	Node node_one, node_two;

	public PriorityQ(int capacity){
		this.cap = cap+1;
		heap = new Node[this.cap];
		heap_size = 0;
	}
	
	public void add(String s, int p){
		Node newNode = new Node(s , p);
		
		heap[++heap_size] = newNode;
		place = heap_size;
		while(place != 1 && newNode.key > heap[place/2].key){
			heap[place] = heap[place/2];
			place /= 2;
		}
		heap[place] = newNode;
	}
	
	public String returnMax(){
		if(isEmpty()){
			System.out.println("error que empty");
			return null;
		}
		return heap[0].val;
	}
	
	public String extractMax(){
		if(isEmpty()){
			System.out.println("error que empty");
			return null;
		}
		return heap[0].val;
	}
	
	public void remove(int i){
		if(isEmpty()){
			System.out.println("error que empty");
			return;
		}
		node_one = heap[i];
		node_two = heap[heap_size--];
		
		parent = 1;
		child = 2;
		while(child <= heap_size){
			if(child < heap_size && heap[child].key < heap[child + 1].key){
				child++;
			}
			if(node_two.key >= heap[child].key){
				break;
			}
			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}
		heap[parent] = node_two;
		
		System.out.println(node_two + "removed from queue");
		//return node_two
		
	}
	
	public void decrementPriority(int i, int o){
		if(isEmpty()){
			System.out.println("error que empty");
			return;
		}
	}
	
	public Node[] priorityArray(){
		if(isEmpty()){
			System.out.println("error que empty");
			return null;
		}
		return null;
	}
	
	public int getKey(int i){
		return 0;
	}
	
	public int getValue(int i){
		return 0;
	}
	
	public boolean isEmpty(){
		return heap_size == 0;
	}
}

class Node {
	public String val;
	public int key;
	
	public Node(String val, int key){
		this.val = val;
		this.key = key;
	}
	public String getVal(){
		return val;
	}
}

class NodeComparator implements Comparator<Node>{
	public int compare(Node node_one, Node node_two){
		if(node_one.key > node_two.key){
			return 1;
		}
		else if(node_one.key < node_two.key){
			return -1;
		}
		return 0;
	}
}