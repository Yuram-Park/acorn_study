package model;

public class FactoryBean {
	private FactoryBean() {} // 외부에서 객체 생성 못하게 막음 
	private static FactoryBean factory = new FactoryBean(); // 딱 하나만 생성되게
	
	public static FactoryBean newInstance() {
		return factory;
	}
	
	public ICommand createInstance(String cmd) {
		if (cmd.equals("REGISTER")) {
			return new RegisterCommand();
		} else if (cmd.equals("CONFIRM")) {
			
			return new ConfirmCommand();
		} else if (cmd.equals("COMPLETE")) {
			return new CompleteCommand();
		} else if (cmd.equals("MAIN")) {
			return new MainCommand();
		} else { 
			return new MainCommand();
		}
	}
}
