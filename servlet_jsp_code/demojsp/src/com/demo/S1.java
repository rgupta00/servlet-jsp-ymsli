package com.demo;
import java.util.*;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//SingleThreadModel : hey container run only one thread at a time ....
// no adv of multithreadnig : (
// poor performace : why hell to use it ...dont use it
@WebServlet("/S1")
public class S1 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//data processing must be done by service layer and controller should act as  a manager
		
		//to dispaly the data (jsp should not do data processing)
//		Person person=new Person();
//		Dog dog=new Dog();
//		dog.setDogName("stonish");
//		person.setDog(dog);
//		HttpSession httpSession=request.getSession();
//		httpSession.setAttribute("person", person);
//		
//		String[] footballTeams = { "Liverpool", "Manchester Utd", "Arsenal", "Chelsea" };
//
//		request.setAttribute("footballList", footballTeams); 
//		
//		
//		java.util.Map<String, String> foodMap = new java.util.HashMap<>();
//
//		foodMap.put("Fruit", "Banana");
//		foodMap.put("TakeAway", "Indian"); 
//		foodMap.put("Drink", "Larger");
//		foodMap.put("Dessert", "IceCream"); 
//		foodMap.put("HotDrink", "Coffee");
//
//		String[] foodTypes = {"Fruit", "TakeAway", "Drink", "Dessert", "HotDrink"};
//		
//
//		request.setAttribute("foodMap", foodMap); 
//		request.setAttribute("foodTypes",foodTypes);
//		
//		
//		
		
		List<String> books=Arrays.asList("java","rich dad poor dad","monk who sold his farrari");
		System.out.println(books);
		request.setAttribute("books", books);
		
		RequestDispatcher rd=request.getRequestDispatcher("showdata.jsp");
		rd.forward(request, response);
		
	}


}
