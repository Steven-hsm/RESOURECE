package com.hsm.multinomial;

public class Multinomials {
	/**
	 * 多项式的加法
	 * @param multinomialA
	 * @param multinomialB
	 * @return
	 */
	public static Multinomial Add(Multinomial multinomialA,Multinomial multinomialB){
		int i=0;//用于遍历multinomialA
		int j=0;//用于遍历multinomialB
		Multinomial multinomialC=new Multinomial();
		Point pointA=null;
		Point pointB=null;
		for(;i<multinomialA.getTerms().size()&&j<multinomialB.getTerms().size();){
			pointA=multinomialA.getTerms().get(i);//获取multinomialA对应位置的值
			pointB=multinomialB.getTerms().get(j);//获取multinomialB对应位置的值
			//比较指数，根据指数执行不同的命令
			if(pointA.getExponent()>pointB.getExponent()){
				multinomialC.getTerms().add(pointA);
				i++;
			}else if(pointA.getExponent()<pointB.getExponent()){
				multinomialC.getTerms().add(pointB);
				j++;
			}else{
				pointA.setCoefficient(pointA.getCoefficient()+pointB.getCoefficient());
				//pointA.setExponent(pointA.getExponent()+pointB.getExponent());
				multinomialC.getTerms().add(pointA);
				i++;
				j++;
			}
		}
		if(j!=multinomialA.getTerms().size()){//multinomialA遍历完成
			for(;j<multinomialB.getTerms().size();j++){
				pointB=multinomialB.getTerms().get(j);
				multinomialC.getTerms().add(pointB);
			}
		}
		if(i!=multinomialA.getTerms().size()){//multinomialB遍历完成
			for(;i<multinomialA.getTerms().size();i++){
				pointA=multinomialA.getTerms().get(i);
				multinomialC.getTerms().add(pointA);
			}
		}
		return multinomialC;
	}
	/**
	 * 测试类
	 * @param args
	 */
	public static void main(String[] args) {
		Point a=new Point(5,8);
		Point b=new Point(6,7);
		Point c=new Point(-1,8);
		Point d=new Point(2,1);
		Multinomial multinomialA=new Multinomial();
		multinomialA.getTerms().add(a);
		multinomialA.getTerms().add(b);
		Multinomial multinomialB=new Multinomial();
		multinomialB.getTerms().add(c);
		multinomialB.getTerms().add(d);
		Multinomial multinomialC= Multinomials.Add(multinomialA, multinomialB);
		System.out.println(multinomialC.toString());
		
	}
}
