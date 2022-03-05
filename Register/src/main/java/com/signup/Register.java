package com.signup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
@MultipartConfig
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String firstname = req.getParameter("firstName");
		String lastname = req.getParameter("lastName");
		String password = req.getParameter("password");
		String email = req.getParameter("email");

		Part part = req.getPart("image");
		String image = part.getSubmittedFileName();

		InputStream is = part.getInputStream();
		byte[] data = new byte[is.available()];
		is.read(data);
		String path = req.getRealPath("/") + "img" + File.separator + image;

		// out.print(firstname + " " + lastname + ", " + password + ", " + email + ", "
		// + image);
		// out.print("Done");
		// System.out.print(path);

		try {
			Thread.sleep(3000);
			MemberRegister member = new MemberRegister(firstname, lastname, password, email, image);
			String status = RegisterDao.createMember(member);
			// upload file...
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			out.println(status);
			fos.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
