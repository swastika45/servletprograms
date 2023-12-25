package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LCTestServlet extends HttpServlet {
 
	static {
		System.out.println("LCTestServlet: static block");
	}
	
	public LCTestServlet() {
		System.out.println("LCTestServlet:: 0-param constructor");
	}
	private ServletConfig  cg;
	public void init(ServletConfig cg) {
		this.cg=cg;
		System.out.println("LCTestServlet: init(-)(1-param) method");
		 String val1=cg.getInitParameter("p1");
		 String val2=cg.getInitParameter("p2");
		 System.out.println("from  init method"+val1+" ...."+val2);
	}
	
	public  void init() {
		System.out.println("LCTestServlet.init()");
		//get Access to ServletConfig object
		  ServletConfig cg=getServletConfig();
		  String val1=cg.getInitParameter("p1");
			 String val2=cg.getInitParameter("p2");
			 System.out.println(val1+" ...."+val2);
	}
	
	
/*	@Override
	protected  void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LCTestServlet.service(-,-) (2nd)");
		 //get PrintWriter object 
		PrintWriter pw=res.getWriter();
		  //set response content type
		  res.setContentType("text/html");
		  //write  output content  to response object
		  pw.println("<h1 style='color:red;text-align:center'> Date  and time is :: "+new Date()+"</h1>");
		  
		  //ServletConfig cg=getServletConfig();
		  String val1=cg.getInitParameter("p1");
			 String val2=cg.getInitParameter("p2");
			 System.out.println("from service(-,-)"+val1+" ...."+val2);
		  
		  //close stream
		  pw.close();
	}*/
	
	@Override
	public  void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("LCTestServlet.service(-,-) (1st)");
		 super.service(req, res);
		 //get PrintWriter object 
		PrintWriter pw=res.getWriter();
		  //set response content type
		  res.setContentType("text/html");
		  //write  output content  to response object
		  pw.println("<h1 style='color:red;text-align:center'> Date  and time is :: "+new Date()+"</h1>");
		  
		  //ServletConfig cg=getServletConfig();
		  String val1=cg.getInitParameter("p1");
			 String val2=cg.getInitParameter("p2");
			 System.out.println("from service(-,-)"+val1+" ...."+val2);
		  
		  //close stream
		  pw.close();
	}
	
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LCTestServlet.doGet(-,-)");
		 //get PrintWriter object 
		PrintWriter pw=res.getWriter();
		  //set response content type
		  res.setContentType("text/html");
		  //write  output content  to response object
		  pw.println("<h1 style='color:red;text-align:center'> Date  and time is :: "+new Date()+"</h1>");
		  
		  //ServletConfig cg=getServletConfig();
		  String val1=cg.getInitParameter("p1");
			 String val2=cg.getInitParameter("p2");
			 System.out.println("from service(-,-)"+val1+" ...."+val2);
		  
		  //close stream
		  pw.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("LCTestServlet:destroy()");
	}
}
