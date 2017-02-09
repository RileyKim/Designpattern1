package com.taeksu.designpattern.singleton;

public class Multiton {
	/*
	 * Multiton
	 * 싱글턴과 반대되는 개념이지만 new라는 의존성을 제거해준다는 장점이 있다.
	 */
	
	//생성자를 private으로 막는
	private Multiton(){
	
	}
	//생성 함수를 제공한다.	
	public static Multiton newInstance(){
	return new Multiton();
	}
	public String name = "";

}
