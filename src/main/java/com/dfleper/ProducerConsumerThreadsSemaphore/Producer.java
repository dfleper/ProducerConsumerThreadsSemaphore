package com.dfleper.ProducerConsumerThreadsSemaphore;

public class Producer extends Thread{
	private Store objStore;
	private String Name;
	
	public Producer(Store objStore, String name) {
		this.objStore = objStore;
		this.Name = name;
	}

	@Override
	public void run() {
		this.objStore.deliver(this.Name);
	}
}
