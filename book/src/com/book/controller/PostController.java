package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.PostService;


@WebServlet("/Post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostService service;
    
    public PostController() {
        super();
        this.service = new PostService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = new String(request.getParameter("Id"));
		String account = new String(request.getParameter("Account").getBytes("ISO-8859-1"),"UTF-8");
		if (service.validUser(id,account)) {
			response.getWriter().append("500 Internal Server Error");
			return;
		}
	}

}
