package com.dfleper.ProducerConsumerThreadsSemaphore;

import java.util.concurrent.Semaphore;

public class Store {
	public final int maxApple = 20;
	public int Apple;
	
	Semaphore SemMutexApple; //binary
	Semaphore SemProApple;
	Semaphore SemConsApple;
	
	
	public Store() {
		this.Apple=0;
		this.SemMutexApple = new Semaphore(1);
		this.SemProApple = new Semaphore(this.maxApple);
		this.SemConsApple = new Semaphore(0);
	}
	
	public void deliver (String Name) {
		
		try {
			this.SemProApple.acquire();
			this.SemMutexApple.acquire();
			this.Apple++;
			System.out.println(Name + " ha añadido una manzana. Número de Manzanas =" + this.Apple);
			this.SemMutexApple.release();
			this.SemConsApple.release();
			//Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remove(String Name) {
		try {
			this.SemConsApple.acquire();
			this.SemMutexApple.acquire();
			this.Apple--;
			System.out.println(Name + " se ha llevado una manzana. Número de Manzanas =" + this.Apple);
			this.SemMutexApple.release();
			this.SemProApple.release();
			//Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
