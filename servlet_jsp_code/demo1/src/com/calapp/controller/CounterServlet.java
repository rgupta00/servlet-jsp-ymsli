package com.calapp.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtomicInteger counter;

	public CounterServlet() {
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// read atomic integer from a file using deserilization
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream
				("/home/raj/Desktop/data/counter.ser"))){
			counter = (AtomicInteger) ois.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// passimistic locking vs OPtimisitc locking
		// AtomicInteger: CAS
		counter.addAndGet(1);

		PrintWriter out = response.getWriter();
		out.print(counter + "<br>");
		out.print("YMSLI" + "<br>");
	}

	@Override
	public void destroy() {
		// dont forget to write last value of couter to the file so that next time i can
		// read it back
		try (ObjectOutputStream oos = new ObjectOutputStream
				(new FileOutputStream("/home/raj/Desktop/data/counter.ser"))){
			oos.writeObject(counter);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
