package com.taeksu.designpattern.proxy;

public class Database {
	public static Bbs readBbs(int bbsno){
		Bbs bbs = new Bbs();
		//데이터를 세팅한 후에 리턴해준다. 
		//로직..
		bbs.no =  bbsno;
		bbs.title = "글제목111";
		bbs.content = "내용입니다.";
				return bbs;
	}
	public static void increaseVisit(int bbsno){
		//Visit 데이터는 현재 Bbs와 별개로 존재한다. 
		
	}
	public static BbsExtend readBbsExtend(int bbsno) {
		BbsExtend bbs = new BbsExtend();
		//데이터를 세팅한 후에 리턴해준다. 
		//로직..
		bbs.no =  bbsno;
		bbs.title = "글제목111";
		bbs.content = "내용입니다.";
		bbs.count = 3;
		return bbs;
	}

}
