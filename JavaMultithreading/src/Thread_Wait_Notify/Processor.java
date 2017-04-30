package Thread_Wait_Notify;

import java.util.Scanner;

public class Processor {

	public void producer() throws InterruptedException {
		synchronized (this) {
			System.out.println("producer thread running...");
			wait();
			System.out.println("Resumed Producer Thread");
		}
	}

	public void consumer() throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Waiting for the return key ... !!!");
			scanner.nextLine();
			System.out.println("Return key Pressed");
			notify();
			Thread.sleep(5000);
		}

	}
}
