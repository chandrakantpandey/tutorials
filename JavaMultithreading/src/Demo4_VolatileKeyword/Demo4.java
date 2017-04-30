package Demo4_VolatileKeyword;

import java.util.Scanner;

class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Hello");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutDown() {
		running = false;
	}
}

public class Demo4 {

	public static void main(String[] args) {
		Processor proc = new Processor();
		proc.start();

		System.out.println("Enter the return key to Stop .........");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		proc.shutDown();
	}

}
