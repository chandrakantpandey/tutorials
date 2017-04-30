package Thread_Wait_Notify;

public class App {
	
	//This queue is default thread safe. very good to use in case of multithreading program.
	//private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public static void main(String[] args) throws InterruptedException {
		
		final Processor processor = new Processor();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}
	
	/*private static void producer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			queue.put(random.nextInt(100));
		}
	}

	private static void consumer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			Thread.sleep(100);
			
			if(random.nextInt(10)==0) {
				Integer value = queue.take();
				System.out.println("Taken Value : " +value + " Queue Size : " +queue.size());
			}
		}
	}*/
}
