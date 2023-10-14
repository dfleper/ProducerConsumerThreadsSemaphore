package com.dfleper.ProducerConsumerThreadsSemaphore;

public class Consumer extends Thread{
	private Store objStore;
	private String Name;
	
	public Consumer(Store objStore, String name) {
		this.objStore = objStore;
		Name = name;
	}

	@Override
	public void run() {
		this.objStore.remove(this.Name);
	}
}
