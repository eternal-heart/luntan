package com.hello;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hello.dao.LoginDao;
import com.hello.dao.RegisterDao;
import com.hello.bean.*;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        
        if(RegisterDao.checkmail(mail)) {
        	if (LoginDao.doLogin(mail, password)) {
                String username=LoginDao.search(mail);
                request.setAttribute("username", username);
                RequestDispatcher rd = request.getRequestDispatcher("log.jsp");
                rd.forward(request, response);
            } else {
                out.print("邮箱或密码错误~！");
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request, response);
            }
        }else {
        	out.print("邮箱未注册");
        	RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        }
        out.close();
    }
}
