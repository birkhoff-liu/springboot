
package com.birkhoff.concurrent.demo.base;



/**
 * 抛出异常释放锁
* @author: birkhoff

 */
public class DemoThread07 {
	
	private int i = 0;
	
	public synchronized void run(){
		while(true){
			i++;
			System.out.println(Thread.currentThread().getName()+"-run>i="+i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
//			int k = 10/0;
			
			if (i == 10) {
				throw new RuntimeException();
			}
		}
	}
	
	public synchronized void get(){
		System.out.println(Thread.currentThread().getName()+"-get>i="+i);
	}
	
	public static void main(String[] args) throws InterruptedException {
		final DemoThread07 demoThread07 = new DemoThread07();
		new Thread(new Runnable() {
			@Override
			public void run() {
				demoThread07.run();
			}
		},"t1").start();
		
		//保证t1线程先执行
		Thread.sleep(1000);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				demoThread07.get();
			}
		},"t2").start();
	}
}
