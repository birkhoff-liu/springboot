
package com.birkhoff.concurrent.demo.base;


/**
 * 锁重入01
 * @author: birkhoff

 */
public class DemoThread05{
	
	public synchronized void run1(){
		System.out.println(Thread.currentThread().getName()+" > run1...");
		//调用同类中的synchronized方法不会引起死锁
		run2();
	}
	
	public synchronized void run2(){
		System.out.println(Thread.currentThread().getName()+" > run2...");
	}
	
	public static void main(String[] args) {
		final DemoThread05 demoThread05 = new DemoThread05();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				demoThread05.run1();
			}
		});
		thread.start();
	}
}
