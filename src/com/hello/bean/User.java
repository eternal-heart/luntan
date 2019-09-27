package com.hello.bean;

import java.util.HashMap;
import java.util.Map;

public class User {
	private String mail;
	private String name;
	private String password;
	private String confirmPwd;
	
	private Map<String, String> errors=new HashMap<String,String>();
	public void setErrors(Map<String,String> errors) {
		this.errors=errors;
	}
	
	public boolean validate() {
		boolean isOk=true;
		
		if (this.name == null || this.name.trim().equals("")) {
            isOk = false;
            errors.put("name", "用户名不能为空！！");
        } else {
            if (!this.name.matches("[a-zA-Z]{3,8}")) {
                isOk = false;
                errors.put("userName", "用户名必须是3-8位的字母！！");
            }
        }

        if (this.password == null || this.password.trim().equals("")) {
            isOk = false;
            errors.put("password", "密码不能为空！！");
        } else {
            if (!this.password.matches("\\d{3,8}")) {
                isOk = false;
                errors.put("password", "密码必须是3-8位的数字！！");
            }
        }

        // private String password2; 两次密码要一致
        if (this.confirmPwd != null) {
            if (!this.confirmPwd.equals(this.password)) {
                isOk = false;
                errors.put("confirmPwd", "两次密码不一致！！");
            }
        }

        // private String email; 可以为空，不为空要是一个合法的邮箱
        if (this.mail == null || this.mail.trim().equals("")) {
            isOk = false;
            errors.put("mail", "邮箱不能为空！！");
        }else{
            if (!this.mail.matches("\\w+@\\w+(\\.\\w+)+")) {
                isOk = false;
                errors.put("email", "邮箱不是一个合法邮箱！！");
            }
        }
        
        return isOk;
	}
	
	
	
	
	
	
	public User (String mail,String name,String password) {
		this.mail=mail;
		this.name=name;
		this.password=password;
	}
	public String getMail() {
		return mail;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
