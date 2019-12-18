package com.main.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Singleton;
@Singleton
public class AddPersonData extends HttpServlet {
	@Inject
	ServicePerson sp;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ServletOutputStream out=resp.getOutputStream();	
			if(req.getParameter("add")!=null)
				{
					String s=req.getParameter("nam");
				    Person p=new Person();
					p.setName(s);		
					sp.addPerson(p);	
					out.println(s);
				}
			if(req.getParameter("delete")!=null)
			{
				   int id=Integer.parseInt(req.getParameter("dname"));				    
				  sp.deletePerson(id);
			}
			if(req.getParameter("update")!=null)
			{
				int id=Integer.parseInt(req.getParameter("uname"));
				 Person p=new Person();
			     p.setName(req.getParameter("nnam"));	
				 sp.updatePerson(p, id);
			}
	resp.sendRedirect("/servletwithjpa/AddPersonServlet");
	}

}
