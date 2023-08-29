class ClassDemo{
	int m_no;
	double m_point;
	
	
}




class ClassTest1{
	int m_ival; // 계획만 세운 것이라서 공간이 만들어진 것은 아님
	double m_dval;
	
	// m_ival = 10; -> 클래스 안에서는 실행안됨
	
	public static void main(String[] args){
		// m_ival = 10; -> 공간 만들어주기 전에는 안됨
		//new ClassTest1().m_ival = 10;
		//System.out.println(new ClassTest1().m_ival);
		
		ClassTest1 i = new ClassTest1(); //참조변수 i를 사용해서 주소를 저장
		i.m_ival = 10;
		System.out.println(i.m_ival);
		
		ClassDemo k = new ClassDemo();
		k.m_no = 10;
		k.m_point = 3.14;
		System.out.println(k.m_no + k.m_point);
	}
}