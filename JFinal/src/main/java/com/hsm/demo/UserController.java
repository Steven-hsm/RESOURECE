package com.hsm.demo;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class UserController extends Controller{
	@ActionKey("/login")
	public void login() {
		render("login.html");
	}
}
