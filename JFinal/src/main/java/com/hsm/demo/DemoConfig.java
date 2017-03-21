package com.hsm.demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig{
	/**
	 * 配置jfinal的常量值
	 */
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
	}
	/**
	 * 配置jfinal的访问路由
	 */
	@Override
	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
	}
	/**
	 * 配置jfinal的常量值
	 */
	@Override
	public void configEngine(Engine arg0) {
		
	}
	/**
	 * 配置jfinal的常量值
	 */
	@Override
	public void configHandler(Handlers arg0) {
	}
	/**
	 * 配置jfinal的常量值
	 */
	@Override
	public void configInterceptor(Interceptors arg0) {
	}
	/**
	 * 配置jfinal的常量值
	 */
	@Override
	public void configPlugin(Plugins arg0) {
	}

	

}
