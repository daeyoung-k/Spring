package com.team404.rconnet;

import java.util.Arrays;

import org.junit.Test;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RConnectTest {
	
	@Test
	public void test() {
		
		/*
		 *1. pom.xml에 연결을 위한 라이브러리 Rserve, Rengine을 추가 
		 *2. Rstudio에서 Rserve를 설치 -> 아래 명령어로 포트번호, 인코딩형식, 기본설정을 세팅
		 *	
		 *	-RStudio에서 실행-
		 *	install.packages('Rserve')
			library(Rserve)
			install.packages('Rserve')
			library(Rserve)
			Rserve(FALSE, port = 6311, args = '--RS-encoding utf8 --no-save --slave --encoding utf8 --internet2')
			Rserve(args = "--RS- encoding utf8")
		 */
		RConnection conn = null;
		
		try {
			
			//1. RConnect로드
			conn = new RConnection("127.0.0.1", 6311); //아이피주소, 포트번호			
			System.out.println(conn);
			
			//eval() 함수는 R코드를 실행.
			//as타입() 함수는 R코드의 실행 결과를 받아옵니다.
			
			//더블형
			double r1 = conn.eval("mean(c(10, 20, 30, 40))").asDouble();
			System.out.println(r1);
			
			//정수형
			int r2 = conn.eval("mean(c(100, 80, 30, 20))").asInteger();
			System.out.println(r2);
			
			//문자열
			String r3 = conn.eval("paste('hello World')").asString();
			System.out.println(r3);
			
			//vector형문자열 -> String배열
			String[] r4 = conn.eval("c('hi','bye', '빠이!')").asStrings();
			System.out.println(Arrays.toString(r4));
			
			//자바에서 매개변수를 넘기고, 동적으로 이미지파일
			//주의할점 
			//1. r에서 줄바꿈으로 처리하는 문법은, 자바에서는 하나의 구문으로 처리하던, 문자열을 +로 연결한 형식으로 표현합니다.
			//2. 이미지형태로 외부로 출력구문은 print()에 감싸서 사용합니다.
			String filename = "자바에서생성한PNG";
			
			conn.eval("setwd('D:\\\\java\\\\upload')");   
			conn.eval(".libPaths('D:\\\\library')");
            conn.eval("library(ggplot2)");
            conn.eval("mpg <- as.data.frame(mpg)");
            conn.eval("print(png(width = 500, height = 500, filename = '"+ filename +".png'))");
            conn.eval("print(ggplot(mpg, aes(x = class, fill=class)) + geom_bar())");
            conn.eval("print(graphics.off())");
			
            //파이프라인과 출력
			conn.eval("library(ggplot2)");
			conn.eval("library(dplyr)");
			conn.eval("d1 <- as.data.frame(mpg) %>% " + 
					"  group_by(manufacturer) %>% " + 
					"  summarise(mean_hwy = mean(hwy))");
			conn.eval("print(png(width = 500, height = 500, filename = 'd1.png'))");
			conn.eval("print(ggplot(d1, aes(x = reorder(manufacturer, mean_hwy), y = mean_hwy, fill = manufacturer)) + " + 
					"  geom_col() +" + 
					"  coord_flip())");
			conn.eval("print(graphics.off())");			
			
			
			
		} catch (RserveException | REXPMismatchException e) {			
			e.printStackTrace();
		} finally {
			try {
				conn.close(); //rconn 해제
			} catch (Exception e2) {
				
			}
		}
	}
}
