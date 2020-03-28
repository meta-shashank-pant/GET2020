package Question3;


public class MaxHeap {

    private Bowler[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new Bowler[this.maxsize + 1];
        Heap[0] = new Bowler(null, Integer.MAX_VALUE);
    }
    
    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private void swap(int firstpos, int secondpos) {
        Bowler temporary;
        temporary = Heap[firstpos];
        Heap[firstpos] = Heap[secondpos];
        Heap[secondpos] = temporary;
    }

    private boolean isLeaf(int pos) 
    { 
        if (pos > (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    private void maxHeapify(int pos) {
        if (isLeaf(pos)) 
            return; 
        if (Heap[pos].balls < Heap[leftChild(pos)].balls
                || Heap[pos].balls < Heap[rightChild(pos)].balls) {

            if (Heap[leftChild(pos)].balls > Heap[rightChild(pos)].balls) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void insert(String name, int balls) 
    { 
        Heap[++size] = new Bowler(name, balls); 
  
        int current = size; 
        while (Heap[current].balls > Heap[parent(current)].balls) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 

    public void show() {
        System.out.println("Virat play "+Heap[1].name+" balls");
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT("+Heap[i].name+") : " + Heap[i].balls + " LEFT CHILD("+Heap[2 * i].name+") : "
                    + Heap[2 * i].balls + " RIGHT CHILD("+Heap[2 * i + 1].name+") :" + Heap[2 * i + 1].balls);
            System.out.println();
        }
    }
    
    public void printHeap(){
    	System.out.println("Final Bowling stats is: ");
    	for(int i=1; i<=size; i++){
    		System.out.println(Heap[i].name+" : "+Heap[i].balls);
    	}
    	System.out.println();
    }

    public int extractMax() {
        int popped = Heap[1].balls - 1;
        Heap[1].balls = popped;
        if (Heap[1].balls == 0 && Heap[2].balls == 0 && Heap[3].balls == 0) {
            show();
            return popped;
        } else if (Heap[1].balls >= 0 && Heap[2].balls >= 0 && Heap[3].balls >= 0) {
            maxHeapify(1);
            show();
        }
        return popped;
    }
}