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
		String addrs=req.getParameter("paddrs");
		 //read  the hidden box value
		String vstatus=req.getParameter("vstatus");
		System.out.println("Client Side Validation status ::"+vstatus);
		
		int age=0;
 if(vstatus.equalsIgnoreCase("disabled")) {		
	//Enable Server Side Form Validation logics
		System.out.println("VoterServlet:: server side form validations");
		List<String> errorsList=new ArrayList();
		 if(name==null || name.equals("") || name.length()==0 ) {  //required rule on name
			   errorsList.add("Person name is required");
		 }
		 else if(name.length()<5) {   // minlength rule on the name
			  errorsList.add("Person name must have >=5 letters");
		 }
		 
		 if(tage==null || tage.equals("") || tage.length()==0) {  //required rule on age
			 errorsList.add("Person age is required");
		 }
		 else {
			 try {
			   age=Integer.parseInt(tage);
			     if(age<=0 || age>=126) {  //range rule on age
			    	 errorsList.add("Person age must be there 1 through 125");
			     }
			 }
			 catch(NumberFormatException nfe) {
				 errorsList.add("Person age must be numeric value");  //age must be numeric vlaue
			 }
		 }
		 
		 if(addrs==null || addrs.equals("") || addrs.length()==0 ) {  //required rule on name
			 errorsList.add("Person address is required");
		 }
		 
		    //print the error messages
		     if(errorsList.size()!=0) {
		    	 pw.println("<ul style='color:red'>");
		    
		    	  // for(String errMsg:errorsList) {   //java5  for-each  loop
		    		  // pw.println("<li>"+errMsg+"</li>");
		    	  // }//for 
		    	
		    	 errorsList.forEach(msg->{       //java8  forEach method
		    		 pw.println("<li>"+msg+"</li>");
		    	 });
		    	 
		    	 System.out.println("Server side form validations are done");
		    	 
		    	 pw.println("</ul>");
		    	 pw.println("<br><a href='input.html'>home </a>");
		    	 
		    	 return  ;
		     }//if 
     } //if
 else {
	 age= Integer.parseInt(tage);
 }
 
			 
		
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
