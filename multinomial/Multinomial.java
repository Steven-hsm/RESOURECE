package com.hsm.multinomial;

import java.util.ArrayList;
/**
 * 多项式
 * @author steven
 *
 */
public class Multinomial {
	private ArrayList<Point> terms=new ArrayList<Point>();

	public ArrayList<Point> getTerms() {
		return terms;
	}

	public void setTerms(ArrayList<Point> terms) {
		this.terms = terms;
	}
	/**
	 * 重写toString方法主要是为了输出查看
	 */
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer("");
		for (Point point : terms) {
			sb.append(point.getCoefficient()+"X"+point.getExponent()+"+");
		}
		return sb.substring(0, sb.length()-1);
	}
}
