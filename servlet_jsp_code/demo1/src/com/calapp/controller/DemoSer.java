package com.calapp.controller;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoSer {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		AtomicInteger atomicInteger=new AtomicInteger(12000);
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("counter.ser"));
		oos.writeObject(atomicInteger);
		System.out.println("----------");
		
	}

}
