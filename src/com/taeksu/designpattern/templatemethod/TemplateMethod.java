package com.taeksu.designpattern.templatemethod;

/*
 * Template Method
 * 부모 클래스인 템플릿 매서드에서 있는 구현된 함수가 
 * 추상 함수를 상속받은 자식 클래스가 구현 메서드를 호출하는 패턴.
 */

public abstract class TemplateMethod {
	public void play(){
		System.out.println("플레이가 시작됩니다.");
		jump();
		
	}
	
	public abstract void jump();
}
