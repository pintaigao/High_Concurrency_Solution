# Synchronized深度解析

## Synchronized简介

能够保证在同一时刻最多只有一个线程执行该段代码，以达到保证并发安全的效果

很多东西都是敲代码，基础的东西不做记录

#### Synchronized的两个用法

**一. 对象锁**：包括**方法锁（默认锁对象为this当前实例对象）**和**同步代码锁（自己指定锁对象）**

* 代码块形式：手动指定锁对象

  ```java
  Object lock1 = new Object();
  synchronized (lock1) {
  	System.out.println("lock1部分: 我叫" + Thread.currentThread().getName());
  	try {
  		Thread.sleep(3000);
  	} catch (InterruptedException e) {
  		e.printStackTrace();
  	}
  	System.out.println("lock1部分: " + Thread.currentThread().getName() + "运行结束");
  }
  ```

* 方法锁形式：synchronized修饰普通方法，锁对象默认为this，两个线程锁要一个一个执行run

  ```java
  @Override
  public synchronized void run() {...}
  ```

**二. 类锁**：指synchronized修饰**静态**的方法或指定锁为**Class对象**

* 概念：Java类可能有很多个对象，但只有1个Class对象，类锁只能在同一时刻被一个对象拥有。
* 形式1：synchronized加载**static**方法上
* 形式2：synchronized**（*.class）**代码块 





# Java并发核心知识体系精讲

