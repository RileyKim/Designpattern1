package com.taeksu.designpattern.singleton;

public class Singleton {
	
	//싱글턴 자신을 닫아두는 변수 공간.
	static Singleton instance = null;
	
	// new 연산자 사용을 못하게 한다.
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		//1. instance 변수에 값이 있는지를 체크한다.
		if(instance ==null){
			instance = new Singleton();
		}
		//2. instance를 리턴한다.
		return instance;
	}
	public String name = "";
}
