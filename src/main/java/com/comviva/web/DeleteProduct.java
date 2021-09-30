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

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/delete-product")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProduct() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("delete-product.html").include(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		
		try {
			SessionFactory factory = HibernateSessionUtil.buildSessionFactory();
			
			Session session = factory.openSession();
			
			Transaction t = session.beginTransaction();
			
			String id = request.getParameter("id");
			
			 Product product = new Product();
			 product.setId(Integer.parseInt(id));
		
			session.delete(product);
			
			t.commit();
			
			if (session != null) {
				out.print("<h3 style='color:green'> Product is deleted sucessfully ! </h3>");
			}

			
			session.close();
			
		} catch (Exception e) {
			out.println("<h3 style = 'color:red'> Error </h3>");
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
