class ConsDemo1 {
	int iVal;
	double dVal;
	
	ConsDemo1(int i){
		System.out.print("������ ȣ���");
	}
	
	ConsDemo1(){
		System.out.print("������ ȣ���yo");
	}
}


public class ConsTest1 {
	public static void main(String[] args) {
		new ConsDemo1(1);
		new ConsDemo1();
	}	
}