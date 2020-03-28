package Question3;

public class Main {

	public static void main(String args[]) {
		int virat_bowl_left = 10;
		System.out.println("The Max Heap is "); 
        MaxHeap maxHeap = new MaxHeap(5); 
        maxHeap.insert("bow1",7); 
        maxHeap.insert("bow2",6); 
        maxHeap.insert("bow3",5); 
        maxHeap.insert("bow4",4); 
        maxHeap.insert("bow5",3);  
        for(int i=0; i < virat_bowl_left; i++){
        	int current_max = maxHeap.extractMax();
        	System.out.print("Current max: "+current_max+" ");
        }
        
        maxHeap.printHeap();
	}
}
