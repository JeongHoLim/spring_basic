package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rollDice2")
public class TwoDice2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idx1 = getRandomInt(6);
		int idx2 = getRandomInt(6);
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Roll Two Dice~</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<div>");
		out.println("<img src = 'resources/img/dice"+idx1+".jpg'>");
		out.println("<img src = 'resources/img/dice"+idx2+".jpg'>");
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
	}

	private int getRandomInt(int num) {
		// TODO Auto-generated method stub
		return new Random().nextInt(num)+1;
	}


}
