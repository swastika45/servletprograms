package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class FormProcessingServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   //set response Content type
		 res.setContentType("text/html");
		 //get PrintWriter 
		 PrintWriter pw=res.getWriter();
		    //read form data
		  String name=req.getParameter("name");
		  int age=Integer.parseInt(req.getParameter("age"));
		  String addrs=req.getParameter("addrs");
		  String gender=req.getParameter("gender");
		  String hobies[]=req.getParameterValues("hb");
		  //handle non-select state for the check boxes
		  hobies=(hobies==null)?new String[] {"no hobies"}:hobies;
		  String ms=req.getParameter("ms");
		   //handle non-select state for the checkbox
		  ms=(ms==null)?"single":ms;
		  String qlfy=req.getParameter("qlfy");
		  String favPlaces[]=req.getParameterValues("favPlaces");
		  //handle non-select state for the list box  (using ternaary operator)
		  favPlaces=(favPlaces==null)?new String[] {"no-fav places"}:favPlaces;
		  long phone=Long.parseLong(req.getParameter("mobileNo"));
		  String favColor=req.getParameter("favColor");
		  String  dob=req.getParameter("dob");
		  String tob=req.getParameter("tob");
		  String doj=req.getParameter("doj");
		  int favNo=Integer.parseInt(req.getParameter("favNo"));
		  String mail=req.getParameter("mailId");
		  String week=req.getParameter("freedomWeek");
		  String instaUrl=req.getParameter("instaUrl");
		  String ss=req.getParameter("ss");
		  long income=Long.parseLong(req.getParameter("income"));
		  
		  //write the b.logic
		  if(gender.equalsIgnoreCase("M")) {
			     if(age<=5) {
			    	 pw.println("<h1> Master."+name+" u r  baby boy </h1>");
			     }
			     else if(age<=12) {
			    	 pw.println("<h1> Master."+name+" u r  small boy </h1>");
			     }
			     else if(age<=19) {
			    	 pw.println("<h1> Mr."+name+" u r  teenage boy </h1>");
			     }
			     else if(age<=35) {
			    	 pw.println("<h1> Mr."+name+" u r  young man </h1>");
			     }
			     else if(age<=50) {
			    	 pw.println("<h1> Mr."+name+" u r  middle-aged man</h1>");
			     }
			     else {
			    	 pw.println("<h1> Mr."+name+" u r senior citizen man</h1>");
			     }
		  }//if
		  else {
			     if(age<=5) {
			    	 pw.println("<h1> Master."+name+" u r  baby girl </h1>");
			     }
			     else if(age<=12) {
			    	 pw.println("<h1> Master."+name+" u r  small girl </h1>");
			     }
			     else if(age<=19) {
			    	   if(ms.equalsIgnoreCase("married")) {
			    	        pw.println("<h1> Mrs"+name+" u r  teenage girl </h1>");
			    	   }
			    	   else {
			    		   pw.println("<h1> Miss"+name+" u r  teenage girl </h1>");
			    	   }
			     }
			  else if(age<=35) {
			     if(ms.equalsIgnoreCase("married")) {
			    	 pw.println("<h1> Mrs."+name+" u r  young woman </h1>");
			      }
			     else {
			    	 pw.println("<h1> Miss"+name+" u r  young woman </h1>");
			      }
			     }
			     else if(age<=50) {
			    	 if(ms.equalsIgnoreCase("married")) {	 
			    		 pw.println("<h1> Mrs."+name+" u r  middle-aged woman</h1>");
			    	 }
			    	 else {
			    		 pw.println("<h1> Miss."+name+" u r  middle-aged woman</h1>");
			    	 }
			     }
			     else {
			    	 if(ms.equalsIgnoreCase("married")) {	  
			    	     pw.println("<h1> Mrs."+name+" u r senior citizen woman</h1>");
			    	 }
			    	 else {
			    		 pw.println("<h1> Miss."+name+" u r senior citizen woman</h1>");
			    	 }
			     }
			     
		  }
		  
		  //print the form data
		  pw.println("<b> name::"+name+"</b><br>");
		  pw.println("<b> age::"+age+"</b><br>");
		  pw.println("<b> address::"+addrs+"</b><br>");
		  pw.println("<b> Gender::"+gender+"</b><br>");
		  pw.println("<b> Hobies::"+Arrays.toString(hobies)+"</b><br>");
		  pw.println("<b> Qualification::"+qlfy+"</b><br>");
				  pw.println("<b> Marital Status::"+ms+"</b><br>");
		  pw.println("<b> Fav Places::"+Arrays.toString(favPlaces)+"</b><br>");
		  pw.println("<b> Phone Number::"+phone+"</b><br>");
		  pw.println("<b> fav color::"+favColor+"</b><br>");
		  pw.println("<b> Fav No::"+favNo+"</b><br>");
		  pw.println("<b> DOB::"+dob+"</b><br>");
		  pw.println("<b> TOB::"+tob+"</b><br>");
		  pw.println("<b> DOJ::"+doj+"</b><br>");
		  pw.println("<b> Instal Url::"+instaUrl+"</b><br>");
		  pw.println("<b> freedom Week::"+week+"</b><br>");
		  pw.println("<b> Search String::"+ss+"</b><br>");
		  pw.println("<b> mail Id::"+mail+"</b><br>");
		  pw.println("<b> income::"+income+"</b><br>");
		  
		  //add home hyperlink
		  pw.println("<h1 style='color:red;text-align:center'><a href='input.html'> home </a></h1>");
		  
		  //close the stream
		  pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
