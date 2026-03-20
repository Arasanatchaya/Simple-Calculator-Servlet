package com.cal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;


@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		double number1 = Double.parseDouble(request.getParameter("number1"));
		double number2 = Double.parseDouble(request.getParameter("number2"));
		String operation = request.getParameter("operation");

		double result = 0;
		String message = "";

		switch(operation)
		{
		    case "add":
		        result = number1 + number2;
		        break;

		    case "sub":
		        result = number1 - number2;
		        break;

		    case "mul":
		        result = number1 * number2;
		        break;

		    case "div": 
		    	if(number2!=0) 
		    	{ 
		    		result=number1/number2;
		    	} 
		    else { 
		    	writer.println("<h2>Cannot divide by zero</h2>");
		    return; 
		    }
		    break; 
		    }
		writer.println("<div style='text-align:center; margin-top:50px;'>");
		writer.println("<h2>Result: " + result + "</h2>");
		writer.println("<br>");
		writer.println("<a href='Form.html' style='padding:10px 20px; background:#4CAF50; color:white; text-decoration:none; border-radius:5px;'>Go Back</a>");
		writer.println("</div>");
}}
