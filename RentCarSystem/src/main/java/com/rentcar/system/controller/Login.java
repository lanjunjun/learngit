package com.rentcar.system.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/Login")
public class Login {

	@RequestMapping(value = "/login")
    public void login() {
		try {	
			int x =0;
			if(x == 0){
				response.getWriter().print("1");
			}else{
				response.getWriter().print("0");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	@RequestMapping(value = "/main")
	public String indexPage(){
		return "main";
	}
	
	protected HttpServletRequest request;  
    protected HttpServletResponse response;  
    protected HttpSession session;  
      
    @ModelAttribute  
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
        this.request = request;  
        this.response = response;  
        this.session = request.getSession();  
    }  
	
}
