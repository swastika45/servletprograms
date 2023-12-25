package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet{

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter object
		 PrintWriter pw=res.getWriter();
		 //set response content type
		   res.setContentType("text/html");
		   //read additional req param value
		   String pval=req.getParameter("s1");
		   //get All Locales in this world
		   Locale locales[]=Locale.getAvailableLocales();
		   //write the b.logic
		   if(pval.equalsIgnoreCase("link1")) {
			   pw.println("<h1> all the languages are </h1>");
			   for(Locale l:locales) {
				   pw.println(l.getDisplayLanguage()+",");
			   }
		   }//if
		   else if(pval.equalsIgnoreCase("link2")) {
			   pw.println("<h1> all the Countries are </h1>");
			   for(Locale l:locales) {
				   pw.println(l.getDisplayCountry()+",");
			   }
		   }//else if
		   else {
			    //get System Date and time
			   LocalDateTime  ldt=LocalDateTime.now();
			   //get current month 
			   int month=ldt.getMonthValue();
			   if(month>=3 && month<=6)
				   pw.println(" <h1 style='color:red;text-align:center'> Summer Season </h1>");
			   else if(month>=7 && month<=11)
				   pw.println(" <h1 style='color:red;text-align:center'> Rainy Season </h1>");
			   else
				   pw.println(" <h1 style='color:red;text-align:center'> Winter Season </h1>");
		   }
		   
		   //add hyperlink
		   pw.println("<a href='links.html'>home </a>");
		   
		   //close the stream
		   pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req,res);
		
	}//doPost(-,-)
	
}//class
