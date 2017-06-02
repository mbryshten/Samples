package mbryshten.blockingqueue;

import java.util.Random;

public class RunBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue queue = new BlockingQueue();

		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				Random random = new Random();

				while(true) {
					
					try {
						queue.enqueue(random.nextInt(100));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while(true) {
					
					try {
						Thread.sleep(1000);
						
						Integer value = queue.dequeue();
						
						System.out.println("Value: " + value);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}
