//PlainServlet.java
package com.nt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;


public class  PlainServlet extends  HttpServlet
{
	static {
		System.out.println("PlainServlet: static block");
	}
	
	public PlainServlet() {
		System.out.println("PlainServlet:0-param constructor");
	}
	
	public void init(ServletConfig cg) {
		System.out.println("PlainSErvlet: init(-) method");
	}

	protected  void  service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		 System.out.println("PlainServlet.service(-,-)");
            //set the response  content type (MIME type)
			  res.setContentType("text/plain");
			//get PrintWriter stream obj
			PrintWriter pw=res.getWriter();
			//write  the messages to  res object
			pw.println("<table  border='1' align='center'  bgcolor='cyan'>");
			pw.println("<tr><th>player </th> <th> sport </th> <th> country </th> </tr>");
           pw.println("<tr><td>dhoni </td> <td> cricket </td> <td> india </td> </tr>");
		    pw.println("<tr><td>sachin </td> <td> cricket </td> <td> india </td> </tr>");
			pw.println("<tr><td> sania</td> <td> tennis </td> <td> indo-pak </td> </tr>");
			pw.println("<tr><td> sindhu</td> <td> Batminton </td> <td> india </td> </tr>");
			pw.println("</table>");

			//close the stream
			pw.close();
	}

}