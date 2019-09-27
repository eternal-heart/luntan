package com.hello.dao;
import java.sql.*;
public class LoginDao {
	 public static boolean doLogin(String mail, String password) {
	        System.out.println("mail : "+mail+", Password："+password);
	        boolean status = false;
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/forum?useSSL=false&&allowPublicKeyRetrieval=true&&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8", "root", "418613");
	            // 邮箱及密码是否正确？
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM userinfo WHERE email=? AND pwd=?");
	            ps.setString(1, mail);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            status = rs.next();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return status;
	    }
	 public static String search(String mail) {
		 Connection con=null;
		 String name=null;
		 try {
			 con=DriverManager.getConnection("jdbc:mysql://localhost/forum?useSSL=false&&allowPublicKeyRetrieval=true&&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8", "root", "418613");
			 PreparedStatement ps=con.prepareStatement("select uerName from forum.userinfo where email=?");
			 ps.setString(1, mail);
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()) {
	                name = rs.getString("uerName");
	            }
		 }catch(Exception e) {
			 System.out.print(e);
		 }
		 return name;
	 }
}
