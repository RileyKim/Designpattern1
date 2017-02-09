package com.taeksu.designpattern.proxy;

/*
 * proxy
 * 대행자로써 
 * 중간에 다른 기능 또는 요구사항을 처리한 후 
 * 클라이언트 요청에 대한 원본 데이터는 변형하지 않고 그대로 전달한다. 
 */

public class Proxy {
	
	private static Proxy instance = null;
	
	private Proxy(){
	}
	
	public static Proxy getInstance(){
		if (instance == null){
			instance = new Proxy();
		}
		return instance;
	}
	
	public Bbs getBbs(int bbsno){
		//데이터 베이스를 통해 가져온다는 가정.
		Bbs bbs = Database.readBbs(bbsno);
		
		//원본데이터는 변형하지않고 조회수 또는 좋아요 수를 증가시켜준다. 
		Visit visit = new Visit();
		visit.increase(bbsno);
		
		return bbs;
	}

}
