package com.hsm.demo;

import com.jfinal.core.JFinal;

public class MainTest {
	public static void main(String[] args) {
		JFinal.start("src/main/webapp",80,"/");
	}
}
