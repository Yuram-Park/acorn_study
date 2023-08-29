class ConsDemo2 {
	int iVal;
	double dVal;
	
	ConsDemo2(int i, double d){
		iVal = i;
		dVal = d;
	}
	void setVal(int i, double d){
		iVal = i;
		dVal = d;
	}
	
	ConsDemo2 (){}
	
}


public class ConsTest2 {
	public static void main(String[] args) {
		ConsDemo2 ob = new ConsDemo2();
		System.out.println(ob.iVal);
		
		//int i;
		//System.out.println(i);
		
		// 검증 코드
		/*
			100이 문제가 있는지 없는지 검증
		*/
		//ob.iVal = 100;
		//ob.dVal = 10.0; -> 직접 변수에 접근하기 보다는
		
		ob.setVal(100, 10.0); // -> 메서드를 이용해서 간접적으로 들어갈 수 있게 할 것
		
		
		ConsDemo2 ob2 = new ConsDemo2(100, 10.0);
	}	
	
}