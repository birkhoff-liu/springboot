/**   
 * 
 * @Title: DemoThread09.java 
 * @Prject: DemoThread
 * @Package: com.liang.demo 
 * @author: yin.hl
 * @date: 2017年3月20日 下午10:55:51 
 * @version: V1.0   
 */
package com.birkhoff.concurrent.demo.base;

/**
 * 死锁
 * 
* @author: birkhoff

 */
public class DemoThread12 {
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void execute1() {
		synchronized (lock1) {
			System.out.println("线程" + Thread.currentThread().getName() + "获得lock1执行execute1开始");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lock2) {
				System.out.println("线程" + Thread.currentThread().getName() + "获得lock2执行execute1开始");
			}
		}
	}

	public void execute2() {
		synchronized (lock2) {
			System.out.println("线程" + Thread.currentThread().getName() + "获得lock2执行execute2开始");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lock1) {
				System.out.println("线程" + Thread.currentThread().getName() + "获得lock1执行execute2开始");
			}
		}
	}
	
	public static void main(String[] args) {
		final DemoThread12 demo = new DemoThread12();
		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.execute1();
			}
		}, "t1").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				demo.execute2();
			}
		}, "t2").start();
	}
}
