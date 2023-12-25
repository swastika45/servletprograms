//HtmlServlet.java
package com.nt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;


public class  HtmlServlet extends  HttpServlet
{
	static {
		System.out.println("HtmlServlet: static block");
	}
	
	public HtmlServlet() {
		System.out.println("HtmlServlet:0-param constructor");
	}
	
	public void init(ServletConfig cg) {
		System.out.println("HtmlSErvlet: init(-) method");
	}


	public   void  service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		 System.out.println("HtmlServlet.service()");
            //set the response  content type (MIME type)
			  res.setContentType("text/html");
			//get PrintWriter stream obj
			PrintWriter pw=res.getWriter();
			//write  the messages to  res object
			pw.println("<table  border='1' align='center'  bgcolor='red'>");
			pw.println("<tr><th>player </th> <th> sport </th> <th> country </th> </tr>");
           pw.println("<tr><td>dhoni </td> <td> cricket </td> <td> india </td> </tr>");
		    pw.println("<tr><td>sachin </td> <td> cricket </td> <td> india </td> </tr>");
			pw.println("<tr><td> sania</td> <td> tennis </td> <td> indo-pak </td> </tr>");
			pw.println("<tr><td> sindhu</td> <td> Batminton </td> <td> india </td> </tr>");
			pw.println("</table>");

			//enable  auto refresh on the generated web page
			  res.setHeader("refresh","10");

			//  generate the system date and time
			  Date d=new Date();
			 //write to response object
             pw.println("<br><h1>  Date and Time is "+d+"</h1>");
			//close the stream
			pw.close();
	}

}