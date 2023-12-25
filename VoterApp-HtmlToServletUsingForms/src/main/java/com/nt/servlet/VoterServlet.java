package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		//get PrintWriter stream object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read  form data from the req obj as the request param values
		String name=req.getParameter("pname");
		String  tage=req.getParameter("page");
		int  age=Integer.parseInt(tage);
		String addrs=req.getParameter("paddrs");
			 
		
		//   write b.logic 
		if(age>=18)
			pw.println("<h1 style='color:green'> Mr/Miss/Mrs."+name+"  u  r elgible for Voting </h1>");
		else
			pw.println("<h1 style='color:red'> Mr/Miss/Mrs."+name+"  u  r not elgible for Voting </h1>");
		
		//add graphical hyperlink
		pw.println("<a href='input.html'><img src='images/home.jpg' width='50' height='50'> home</a>");
		
		//close the stream
		pw.close();
		
	}//doGet(-,-)

}//class
