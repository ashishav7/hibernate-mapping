package com.comviva.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.comviva.util.HibernateSessionUtil;

@WebServlet("/init-session")
public class InitSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InitSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
	
		try {
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			Session session = factory.openSession();
			
			if(session!=null) {
				out.println("<h3 style = 'color:green'> Session initialized succesfully </h3>");
			}
			
			session.close();
			
		} catch (Exception e) {
			out.println("<h3 style = 'color:red'> Error </h3>");
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
