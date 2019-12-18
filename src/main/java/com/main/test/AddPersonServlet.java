package com.main.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import antlr.collections.List;

@Singleton
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	ServicePerson sp;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream out=resp.getOutputStream();
		java.util.List<Person> l=sp.DisplayPerson();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=1><td>");
		out.println("<h1>Person Information<h1>");
		out.println("<form action='/servletwithjpa/AddPersonData' method='get'>");
		out.println("<table  border=1><center><h6>Add Data</h6></center><tr>");
		out.println("<tr><td>Enter Your name</td><td><input type='text' name='nam'></td></tr>");
		out.println("<tr><td><input type='submit' value='add' name='add'></td></tr>");
		
		out.println("</tr><tr><table border =1><center><h6>Delete  Data</h6></center><tr><td>Enter Your name:</td><td><select name='dname'>");	
		for (Person m : l) {
				out.println(" <option value='"+m.getId()+"'>"+m.getName()+"</option>");
		}
		
		out.println("<tr><td><input type='submit' value='delete' name='delete'></td></tr></tr>");
		
		out.println("</tr><tr><table border =1><center><h6>Update Data</h6></center><tr><td>Enter Your name:</td><td><select name='uname'>");	
		for (Person m : l) {
				out.println(" <option value='"+m.getId()+"'>"+m.getName()+"</option>");
		}
		out.println("<tr><td>Enter New Name:</td><td><input type='text' name='nnam'></td></tr>");
		out.println("<tr><td><input type='submit' value='update' name='update'></td></tr></table></td>");
		
		out.println("<td>");
		out.println("<td><table>");		
		
		for (Object p : l) {
		     out.println(p.toString()+"</br>");
		}
		out.println("</table></td>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}


}
