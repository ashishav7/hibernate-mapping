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
import org.hibernate.Transaction;

import com.comviva.model.Product;
import com.comviva.util.HibernateSessionUtil;

@WebServlet("/add-product")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddProduct() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("add-product.html").include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("index.html").include(request, response);
		
		try {
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			Session session = factory.openSession();
			
			Transaction t = session.beginTransaction();
			
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			Product product = new Product(name, Double.parseDouble(price));
			
			session.save(product);
			
			t.commit();
			
			if (session != null) {
				out.print("<h3 style='color:green'> Product is created sucessfully ! </h3>");
			}

			
			session.close();
			
		} catch (Exception e) {
			out.println("<h3 style = 'color:red'> Error </h3>");
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
