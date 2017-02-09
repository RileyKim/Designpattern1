package com.taeksu.designpattern.proxy;


/*
 * Decorator
 * Proxy와 비슷한 형태의 패턴이지만 
 * 클라이언트 요청에 대한 원본데이터를 가공한 후 전달한다.
 */
public class Decorator {
	
private static Decorator instance = null;
	
	private Decorator(){
	}
	
	public static Decorator getInstance(){
		if (instance == null){
			instance = new Decorator();
		}
		return instance;
	}
	
	public BbsExtend getBbs(int bbsno){
		//데이터 베이스를 통해 가져온다는 가정.
		BbsExtend bbs = Database.readBbsExtend(bbsno);
		//원본 데이터를 가져와서 수정한 후 넘겨준다.
		bbs.count = bbs.count +1;
		bbs.title = "제목" + bbs.title;
		
		return bbs;
	}

}
