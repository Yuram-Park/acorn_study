class MethodTest {
	/*
	void sum(int n1, int n2) {
		System.out.println("두 수의 합계");
		int result = n1 +n2;
		System.out.println("결과: "+result);
	}
	
	public static void main(String[] args) {
		int num1 = 10, num2 = 15;
		
		//sum(num1, num2); // 안됨
		
		new MethodTest().sum(num1,num2);
	}
	*/
	/*
	int sum(int n1, int n2) {
		System.out.println("두 수의 합계");
		int result = n1 +n2;
		return result;
	}
	
	public static void main(String[] args) {
		int num1 = 10, num2 = 15;
		
		//sum(num1, num2); // 안됨
		
		int result = new MethodTest().sum(num1,num2);
		System.out.println("결과: "+result);
	}
	*/
	int num1 = 10, num2 = 15;
	int result;
	
	void sum(MethodTest m) {
		m.result = m.num1 +m.num2;
	}
	
	public static void main(String[] args) {
		System.out.println("두 수의 합계");
		MethodTest m2 = new MethodTest();
		m2.sum(m2);
		System.out.println("결과: "+m2.result);
	}
}