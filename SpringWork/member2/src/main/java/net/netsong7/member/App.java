package net.netsong7.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.netsong7.member.model.RegisterRequest;
import net.netsong7.member.service.ChangePasswordService;
import net.netsong7.member.service.MemberInfoPrinter;
import net.netsong7.member.service.MemberListPrinter;
import net.netsong7.member.service.MemberRegisterService;

public class App {
	private static ApplicationContext ctx;
	
    public static void main( String[] args ) throws IOException {
    	ctx = new ClassPathXmlApplicationContext("config/application_context_config.xml");
    	
    	// 간단 회원가입 프로그램 예제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	System.out.println("명령어를 입력하세요: ");
        	String command = br.readLine();
        	
        	if(command.equalsIgnoreCase("exit")) {
        		System.out.println("프로그램을 종료합니다.");
        		break;
        	}
        	
        	if(command.startsWith("new ")) {
        		newCommand(command.split(" "));
        		continue;
        		
        	} else if(command.startsWith("change ")) {
        		changeCommand(command.split(" "));	
        		continue;
        		
        	} else if(command.equals("list")) { //전체조회
        		infoList();
        		continue;
        	} else if(command.startsWith("info ")) {
        		infoCommand(command.split(" "));
        		continue;
        	}
        	
        	printHelp();
        }
    }
    
    private static void newCommand(String cmd[]) {
    	if(cmd.length != 5) {
			printHelp();
			return;
		}
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail(cmd[1]);
		req.setName(cmd[2]);
		req.setPassword(cmd[3]);
		req.setConfirmPassword(cmd[4]);
		
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 맞지 않습니다.\n");
			return;
		} else {
			regSvc.regist(req);
			System.out.println("등록되었습니다.\n");
		}
    }
    
    private static void changeCommand(String cmd[]) {
    	if(cmd.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService changePwdSvc = ctx.getBean("memberPwdSvc", ChangePasswordService.class);
		changePwdSvc.changePassword(cmd[1], cmd[2], cmd[3]);
		System.out.println("암호를 변경했습니다.");
    }
    
    private static void printHelp() {
    	System.out.println();
    	System.out.println("잘못된 명령어 입니다.");
    	System.out.println("new 이메일 이름 암호 암호확인");
    	System.out.println("change 이메일 현재암호 바꿀암호");
    	System.out.println("info 이메일");
    	System.out.println();
    }
    
    private static void infoCommand(String cmd[]) {
    	if(cmd.length != 2) {
    		printHelp();
    		return;
    	}
    	MemberInfoPrinter memInfoPrt = ctx.getBean("memberInfoPrt", MemberInfoPrinter.class);
    	memInfoPrt.printMemberInfo(cmd[1]);
    }
    
    private static void infoList() {
    	MemberListPrinter memListPrt = ctx.getBean("memberListPrt", MemberListPrinter.class);
    	memListPrt.printAll();
    }
}
