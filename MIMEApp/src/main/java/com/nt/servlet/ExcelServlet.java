//ExcelServlet.java
package com.nt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;


public class  ExcelServlet extends  HttpServlet
{

	protected  void  service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
            //set the response  content type (MIME type)
			  res.setContentType("application/vnd.ms-excel");
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