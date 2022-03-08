package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.client.Client;
import com.clientService.ClientService;

@Autowired
private ClientService clientService;

@RequestMapping(value = "/")
public ModelAndView listClient(ModelAndView model) throws IOException {
	
	model.setViewName("login");
	return model;
}

@RequestMapping(value = "/showbookbyname", method = RequestMethod.GET)
public ModelAndView showBookByName(HttpServletRequest request,ModelAndView model) {
	String  name= request.getParameter("bookname");
	List<Book> listBookName = bookService.getBookByName("wonder");
	model.addObject("listname", listBookName);
	model.setViewName("output");
	return model;
}
@RequestMapping(value = "/showbookbyauthor", method = RequestMethod.GET)
public ModelAndView showBookByAuthor(HttpServletRequest request,ModelAndView model) {
	String  author= request.getParameter("bookauthor");
	List<Book> listBookAuthor = bookService.getBookByAuthor(author);
	model.addObject("listname", listBookAuthor);
	model.setViewName("output");
	return model;
}
@RequestMapping(value = "/showbookbycategory", method = RequestMethod.GET)
public ModelAndView showBookByCategory(HttpServletRequest request,ModelAndView model) {
	String  category= request.getParameter("bookcategory");
	List<Book> listBookCat = bookService.getBookByCategory(category);
	model.addObject("listname", listBookCat);
	model.setViewName("output");
	return model;
}

}
