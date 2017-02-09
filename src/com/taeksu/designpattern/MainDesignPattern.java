package com.taeksu.designpattern;

import com.taeksu.designpattern.factorymethod.FactoryMethod;
import com.taeksu.designpattern.factorymethod.Packed;
import com.taeksu.designpattern.factorymethod.Product;
import com.taeksu.designpattern.factorymethod.TVFactory;
import com.taeksu.designpattern.proxy.Bbs;
import com.taeksu.designpattern.proxy.Proxy;
import com.taeksu.designpattern.singleton.Multiton;
import com.taeksu.designpattern.singleton.Singleton;
import com.taeksu.designpattern.strategy.Soldier;
import com.taeksu.designpattern.strategy.Strategy;
import com.taeksu.designpattern.strategy.StrategyGun;
import com.taeksu.designpattern.strategy.StrategySheild;
import com.taeksu.designpattern.strategy.StrategySword;
import com.taeksu.designpattern.templatemethod.Frog;
import com.taeksu.designpattern.templatemethod.Rabbit;

public class MainDesignPattern {
	
	
	public static void main(String[] arg) {
		
		
		//1. 싱글 패턴 사용해보기 
		Singleton single1 = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		
		System.out.printf("single1.name=%s single2.name=%s \n", single1.name, single2.name);
		single1.name = "홍길동";
		System.out.printf("single1.name=%s single2.name=%s \n", single1.name, single2.name);
		
		//2. 멀티턴 패턴 사용해보기 
		Multiton multi1 = Multiton.newInstance();
		Multiton multi2 = Multiton.newInstance();
		
		System.out.printf("multi1.name=%s Multi2.name=%s \n", multi1.name, multi2.name);
		multi1.name = "이순신";
		System.out.printf("multi1.name=%s Multi2.name=%s \n", multi1.name, multi2.name);
		
		//3. 싱글턴에 newInstance()함수를 추가하고 변 single3에 적용한 후 single3.name을 출력해보세요
		Singleton single3 = Singleton.getInstance();
		System.out.printf("single3.name=%s ", single3.name);
		
		//4. 프록시 패턴을 사용해봅니다.
		Proxy proxy = Proxy.getInstance();
		Bbs bbs = proxy.getBbs(33);
		System.out.printf("no=%d, title=%s, content=%s \n", bbs.no, bbs.title, bbs.content);
		
		//5. 템플릿 메서드 패턴을 사용합니다.
		Frog frog = new Frog();
		frog.play();
		Rabbit rabbit = new Rabbit();
		rabbit.play();
		
		//6. 팩토리 매서드 패턴을 사용합니다.
		FactoryMethod factory = new TVFactory();
		Product product = factory.make();
		Packed packed = factory.pack(product);
		
		//7. 전략 패턴을 사용합니다. Main이 클라이언트 
		Strategy strategy = null;
		Soldier context = new Soldier();
		
		context.status = Soldier.NEAR;
		//전략패턴은 전략 인터페이스를 구현한 구현체를 주입한다.
		if(context.status == Soldier.ATTACKED){
			strategy = new StrategySheild();
		}else if(context.status ==Soldier.NEAR) {
			strategy = new StrategySword();
		}else{
			strategy = new StrategyGun();
		}
		//전략을 컨텍스트에 넘겨서 사용한다.
		context.useStrategy(strategy);
		
		
		//8. 전략 CallBack 패턴을 사용합니다.
		// 전략 패턴과 동일한데 전략 자체를 클라이언트에서 익명 객체로 생성한다.
		Strategy strategy2 = null;
		Soldier context2 = new Soldier();
		
		context2.status = Soldier.NEAR;
		//전략 callback은 구현체를 사용하지 않고 익명객체를 코드상에서 구현해준다.
		if(context2.status == Soldier.ATTACKED){
			context2.useStrategy(new Strategy(){
				//익명객체란?
				//변수가 없이 instance가 생성되는 것을 가르킨다.
				//아래와 같이 변수를 지정하지 않고 바로 초기화 할 수 있지만 
				//초기화딘 곳 이외에서는 사용할 수 없다.
				@Override
				public void runStrategy() {
					useSheild();
					System.out.println("막는다");
				}

				private void useSheild() {
					System.out.println("방패를 양손으로 잡고");
				}
			});
		}else if(context.status ==Soldier.NEAR) {
			context2.useStrategy(new Strategy(){

				@Override
				public void runStrategy() {
					
					System.out.println("찌른다.");
				}
			});
		}else{
			context2.useStrategy(new Strategy(){

				@Override
				public void runStrategy() {
					
					System.out.println("쏜다.");
				}
			});
		}
	}
}

