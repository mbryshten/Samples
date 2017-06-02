package mbryshten.blockingqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

	private Object lock = new Object();

	private LinkedList<Integer> list = new LinkedList<Integer>();

	private final int SIZE = 10;

	public void enqueue(Integer value) throws InterruptedException {


		synchronized(lock) {
			
			while(list.size() == SIZE) {
				lock.wait();
			}

			list.add(value);
			
			System.out.println("Adding " + value);
			
			lock.notify();			
		}

	}

	public Integer dequeue() throws InterruptedException {
		
		System.out.println("dequeue called");

		synchronized(lock) {
			while(list.size() == 0) {
				lock.wait();
			}

			Integer value = list.removeFirst();
			lock.notify();

			return value;
		}
	}

}
