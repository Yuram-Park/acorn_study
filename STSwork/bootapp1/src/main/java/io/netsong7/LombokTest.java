package io.netsong7;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//public class LombokTest {
//	
//	private String hello;
//	private int count;
//	
//	public static void main(String[] args) {
//		LombokTest test = new LombokTest();
//		test.setHello("안녕하세요");
//		test.setCount(10);
//		
//		System.out.println(test.getHello());
//		System.out.println(test.getCount());
//	}
//
//}


@Getter
@RequiredArgsConstructor // 생성자로 자동주입하는 방법 -> final로 지정해줘야함
public class LombokTest {
	
	private final String hello;
	private final int count;
	
	public static void main(String[] args) {
		LombokTest test = new LombokTest("안녕하세요", 100);
		
		System.out.println(test.getHello());
		System.out.println(test.getCount());
	}

}
