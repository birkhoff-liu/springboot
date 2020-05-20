
package com.birkhoff.concurrent.demo.base;


/**
 * 脏读
 * @author: birkhoff

 */
public class DemoThread04 {

	private String name = "张三";
	private String address = "大兴";

	public /*synchronized*/ void setVal(String name, String address) {
		this.name = name;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.address = address;
		System.out.println("setValue 最终结果：username = " + name + " , address = " + address);
	}

	public /*synchronized*/ void getVal() {
		System.out.println("getValue 方法得到：username = " + this.name + " , address = " + this.address);
	}

	public static void main(String[] args) throws Exception {

		final DemoThread04 dr = new DemoThread04();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setVal("李四", "昌平");
			}
		});
		t1.start();
		
		Thread.sleep(1000);

		dr.getVal();
	}

}
