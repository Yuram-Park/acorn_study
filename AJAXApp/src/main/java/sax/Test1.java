package sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Test1 extends DefaultHandler{ // DefaultHandler를 상속받은 class만 SAX를 처리할 수 있다.
    int cnt=0;
    @Override
    public void startDocument() throws SAXException { // root 시작 태그 만났을때 호출됨
        System.out.println("문서의 시작");
    }

    @Override
    public void endDocument() throws SAXException { // end 끝 태그 만났을 때 호출됨
        System.out.println("문서의 끝");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) // 시작 태그를 만났을 때 호출되는 메서드,  localName = tag이름 / qName = full name
            throws SAXException {
        System.out.println("시작 태그:" + qName + "," +attributes);  
        System.out.println(attributes.getValue("age")+","+attributes.getValue("addr"));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException { // 끝 태그를 만났을 때 호출되는 메서드
        System.out.println("끝 태그:" + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException { //tag 사이 text 값만 받아올때
        System.out.println("-----------");
        System.out.println(cnt++);
        System.out.println(start + ":" + length);
        
        for(int i=start; i<start+length; i++) {
            System.out.print(ch[i]);
        }
        System.out.println();
        System.out.println("-----------");
    }
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        
        SAXParserFactory factory = SAXParserFactory.newInstance(); // SAX 방식으로 만들어진 공장

        SAXParser parser = factory.newSAXParser(); // 작업실 만들어줌
        
        File f = new File("C:\\netsong7\\JspWork\\EclipseWork\\AJAXApp\\src\\main\\webapp\\sax\\test.xml"); // file내용을 읽는게 아니라 정보만 가져옴
        Test1 test1 = new Test1();
        
        parser.parse(f, test1); // 파일을 test1 java파일로 처리할것임
        
        
    }

    

}
