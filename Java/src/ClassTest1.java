class ClassDemo{
	int m_no;
	double m_point;
	
	
}




class ClassTest1{
	int m_ival; // ��ȹ�� ���� ���̶� ������ ������� ���� �ƴ�
	double m_dval;
	
	// m_ival = 10; -> Ŭ���� �ȿ����� ����ȵ�
	
	public static void main(String[] args){
		// m_ival = 10; -> ���� ������ֱ� ������ �ȵ�
		//new ClassTest1().m_ival = 10;
		//System.out.println(new ClassTest1().m_ival);
		
		ClassTest1 i = new ClassTest1(); //�������� i�� ����ؼ� �ּҸ� ����
		i.m_ival = 10;
		System.out.println(i.m_ival);
		
		ClassDemo k = new ClassDemo();
		k.m_no = 10;
		k.m_point = 3.14;
		System.out.println(k.m_no + k.m_point);
	}
}