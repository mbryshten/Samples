package mbryshten.blockingqueue;

import java.util.concurrent.CompletableFuture;

public class CompletableFeatureTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("1");
		
		CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
			
			System.out.println("3");
		
		});
		
		Thread.sleep(1000);
		
		System.out.println("2");
		
	}

}
