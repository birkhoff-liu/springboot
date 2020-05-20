package com.birkhoff.concurrent.demo.high.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
* @author: birkhoff

 */
public class SingleThreadExecutorTest {

	public static void main(String[] args) {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			Runnable task = new Runnable() {
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName()+">>"+index);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			singleThreadExecutor.execute(task);
		}
		
		singleThreadExecutor.shutdown();
	}

}
