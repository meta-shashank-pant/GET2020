package Question2;

class Queue {
	int element;
	int priority;

	//constructor
	Queue(int element, int priority){
		this.element = element;
		this.priority = priority;
	}
}

public class PriorityQueue {

	Queue queue[] = new Queue[100];
	static int top = 0;
	static int highest_priority = 0;
	static int lowest_priority = 100;
	static int highest_priority_element = 0;
	
	//constructor
	public PriorityQueue(int element, int priority) {
		// TODO Auto-generated constructor stub
		Queue que = new Queue(element, priority);
		insert(que);

	}

	//default constructor
	public PriorityQueue() {
		// TODO Auto-generated constructor stub
	}

	void insert(Queue que) {
		
		//If queue is full then we can replace the lowest priority element if current element has more priority than current lowest.
		if(top == 100){
			if(lowest_priority < que.priority){
				deleteLowestPriority();
			}
		}
		
		queue[top] = que;
		
		//Set highest priority
		if(que.priority >= highest_priority) {
			highest_priority = que.priority;
			highest_priority_element = que.element;
		}
		
		//Set lowest priority
		if(que.priority <= lowest_priority)
			lowest_priority = que.priority;
		
		top++;
	}

	private void deleteLowestPriority() {
		
		boolean flag = false;
		for(int i = 1; i < top; i++){
			if(queue[i-1].priority == lowest_priority)
				flag = true;
			if(flag)
				queue[i-1] = queue[i];

		}
		top--;
		
	}

	void delete() {
		if(top == 0){
			System.out.println("There is no element in Queue.");
			return;
		}
		for(int i = 1; i < top; i++)
			queue[i-1] = queue[i];

		top--;

	}

	String getHighestPriority() {
	
		if(top == 0)
			return "There is no element in Queue.";
		else
			return highest_priority_element+"  -  "+highest_priority;
	}

	void deleteHighestPriority() {
		if(top == 0){
			System.out.println("There is no element in Queue.");
			return;
		}
		
		boolean flag = false;
		for(int i = 1; i < top; i++){
			if(queue[i-1].priority == highest_priority)
				flag = true;
			if(flag)
				queue[i-1] = queue[i];

		}
		top--;
	}
	
	void show() {
		System.out.println("Element\t\t\tPriority");
		System.out.println("---------------------------------");
		for(int i = 0; i < top; i++){
			System.out.print(queue[i].element + "\t\t\t" + queue[i].priority);
			System.out.println();
		}
	}


}
