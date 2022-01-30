package com.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	private RegisterDao dao;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		String name = req.getParameter("uname");
		String password = req.getParameter("upass");
		String email = req.getParameter("uemail");
		String gender = req.getParameter("ugender");
		String address = req.getParameter("uaddress");
		String condition = req.getParameter("condition");

		if (condition != null) {
			if (condition.equals("checked")) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				MemberRegister member = new MemberRegister(name, password, email, gender, address);
				dao = new RegisterDao();
				String result = dao.createMember(member);
				System.out.println("Result coming from Dao class : " + result);
				out.println(result);
			}
		} else {
			out.println("Please agree terms and conditions first...!!!");
		}

	}

}
