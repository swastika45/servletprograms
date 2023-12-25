package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  //get PrintWriter 
		  PrintWriter pw=res.getWriter();
		  //set the response content type
		   res.setContentType("text/html");
		   //read  addtional  s1  request parma value
		   String pVal=req.getParameter("s1");
		   // read form data   only when submit buttons are clicked
		    float val1=0,val2=0;
		    LocalDateTime  ldt=null;
		    if(!pVal.equalsIgnoreCase("link1") && !pVal.equalsIgnoreCase("link2")) {
		    	val1=Float.parseFloat(req.getParameter("t1"));
		    	val2=Float.parseFloat(req.getParameter("t2"));
		    }
		    else {  //  creating LocalDateTime class obj only when hyperlink is clicked
		    	ldt=LocalDateTime.now();  //gives the system date and time
		    }
		    
		    //differentiate the logics for  the submit buttons and hyperlinks
		    if(pVal.equalsIgnoreCase("add")) {
		    	pw.println(" <h1> Addition ::"+(val1+val2)+"</h1>");
		    }
		    else if(pVal.equalsIgnoreCase("sub")) {
		    	pw.println(" <h1> Subtraction ::"+(val1-val2)+"</h1>");
		    }
		    else if(pVal.equalsIgnoreCase("mul")) {
		    	pw.println(" <h1> Multiplication ::"+(val1*val2)+"</h1>");
		    }
		    else if(pVal.equalsIgnoreCase("div")) {
		    	pw.println(" <h1> Division ::"+(val1/val2)+"</h1>");
		    }
		    else if(pVal.equalsIgnoreCase("link1")) {
		    	  //get current hour of the day
		    	   int hour=ldt.getHour();
		    	   //generate wish message based on the current hour of the day
		    	   if(hour<12)
		    		   pw.println("<h1> Good Morning </h1>");
		    	   else if(hour<16)
		    		   pw.println("<h1> Good Afternoon </h1>");
		    	   else if(hour<20)
		    		   pw.println("<h1> Good Evening </h1>");
		    	   else 
		    		   pw.println("<h1> Good Night</h1>");
		    }
		    else {
		    	   //get  current  month
		    	   int month=ldt.getMonthValue();
		    	 //generate the season name based on the  current month 
		    	
		    	   if(month>=3 && month<=6)
		    		   pw.println("<h1> Summer Season </h1>");
		    	   else if(month>=7 && month<=11)
		    		   pw.println("<h1>  Rainy Season </h1>");
		    	   else 
		    		   pw.println("<h1> Winter Sesson </h1>");
		    }//else
		    
		    
		    //add the home hyperlink
		    pw.println("<br><br> <h1  style='color:red;text-align:center'><a href='input.html'>home</a></h1>");
		  
		   //close the stream
		    pw.close();
	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}

}
