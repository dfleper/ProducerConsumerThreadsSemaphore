package com.dfleper.ProducerConsumerThreadsSemaphore;

public class App 
{
    public static void main( String[] args )
    {
    	Store objStore = new Store();
    	
    	for (int i =1; i <=20; i++) {
    		new Consumer (objStore, "Consumidor " + i).start();
    	}
    	
    	for (int i =1; i <=20; i++) {
    		new Producer ( objStore, "Productor " + i).start();
    	}
    }
}
