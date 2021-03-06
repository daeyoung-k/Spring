package ex07.quiz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Cumputer {
	
	//키보드, 마우스, 모니터에 대한 멤버변수를 만들고, resource, autowired를 사용해서 자동주입.
	//main에서 cumputer의 info 기능을 확인	
	
	@Resource(name = "mouse")
	private Mouse mouse;
	
	@Autowired
	@Qualifier("monitor")
	private Monitor monitor;
	
	@Autowired
	@Qualifier("keyboard")
	private Keyboard keyboard;
	
	
	public void cumputerinfo() {
		mouse.info();
		monitor.info();
		keyboard.info();
	}
	
	
}
