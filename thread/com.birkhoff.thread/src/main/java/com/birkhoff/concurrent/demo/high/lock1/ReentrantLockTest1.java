package com.birkhoff.concurrent.demo.high.lock1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
* @author: Kevin
* @官网: 	www.mimaxueyuan.com
* @Q Q群:	660567408
* @Email:	mimaxueyuan@163.com

*/
public class ReentrantLockTest1 {

	private Lock lock = new ReentrantLock();

	public void run1() {
		try {
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入run1..");
			Thread.sleep(1000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "退出run1..");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void run2() {
		try {
			lock.lock();
			System.out.println("当前线程:" + Thread.currentThread().getName() + "进入run2..");
			Thread.sleep(2000);
			System.out.println("当前线程:" + Thread.currentThread().getName() + "退出run2..");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {

		final ReentrantLockTest1 ur = new ReentrantLockTest1();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ur.run1();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				ur.run2();
			}
		}, "t2");

		t1.start();
		t2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
