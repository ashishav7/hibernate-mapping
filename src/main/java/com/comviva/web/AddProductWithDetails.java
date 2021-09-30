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
import com.comviva.model.ProductDetails;
import com.comviva.util.HibernateSessionUtil;

@WebServlet("/add-product-with-details")
public class AddProductWithDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddProductWithDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("add-product-with-details.html").include(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
			
			String dimensions = request.getParameter("dimensions");
			String description = request.getParameter("description");
			String brand = request.getParameter("brand");
			int weight = Integer.parseInt(request.getParameter("weight"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			
			
			Product product = new Product(name, Double.parseDouble(price));
			ProductDetails productDetails = new ProductDetails(dimensions,description,brand,weight,stock); 
			product.setDetails(productDetails);
			
			session.save(product);
			
			t.commit();
			
			if (session != null) {
				out.print("<h3 style='color:green'> Product is created with details sucessfully ! </h3>");
			}

			
			session.close();
			
		} catch (Exception e) {
			out.println("<h3 style = 'color:red'> Error </h3>");
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
