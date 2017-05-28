package com.hsm.multinomial;
/**
 * 用于对多项式的每一项进行分类
 * @author steven
 *
 */
public class Point {
	private int coefficient;//系数
	private int exponent;//指数
	
	public Point(int coefficient, int exponent) {
		super();
		this.coefficient = coefficient;
		this.exponent = exponent;
	}
	public Point(){
		
	}
	/**
	 * 获取系数
	 * @return
	 */
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	//获取指数
	public int getExponent() {
		return exponent;
	}
	public void setExponent(int exponent) {
		this.exponent = exponent;
	}
	
}
