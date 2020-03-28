package Question2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue pq = new PriorityQueue(15, 3);
		pq.insert(new Queue(21,20));
		pq.insert(new Queue(300,5));
		pq.insert(new Queue(12,7));
		pq.insert(new Queue(14,9));
		pq.show();
		System.out.println();
		pq.delete();
		pq.show();
		System.out.println();
		pq.deleteHighestPriority();
		pq.show();
		
		
		
		
//		System.out.println(pq.getHighestPriority());
//		pq.insert(new Queue(99,900));
//		System.out.println(pq.getHighestPriority());
//		pq.show();
//		pq.insert(new Queue(121,17));
//		System.out.println();
//		pq.show();
//		System.out.println();
//		pq.delete();
//		pq.delete();
//		pq.show();
	}

}
