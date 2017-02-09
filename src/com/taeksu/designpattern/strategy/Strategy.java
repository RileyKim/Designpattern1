package com.taeksu.designpattern.strategy;

/*
 * Strategy
 * 템플릿 패턴과 유사한데, 템플릿 패턴이 상속을 이용하는 반면
 * Strategy패턴은 객체 주입을 통해 다양한 결과를 도출할 수 있다.
 * 
 * 기본적으로 아래 3요소가 필요하다.
 * 1. 전략 : 실제 로직을 구현하는 객체
 * 2. 컨텍스트 : 전략을 사용하는 객체
 * 3. 클라이언트 : 전략 객체를 생성한 후 컨텍스트에 주입하는 객체.
 */

public interface Strategy {
	public void runStrategy();
}
