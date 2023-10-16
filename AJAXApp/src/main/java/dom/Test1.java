package dom;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document; //import 주의!! xml관련해서 여러 마크업 객체 문서 볼수있음
import org.xml.sax.SAXException;
import org.w3c.dom.Node; //xml 접근용
import org.w3c.dom.Element; //xml 접근용

public class Test1 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // new로 객체 생성하지 않고 이미 생성돼있는거 가져옴(xml을 다루는 공간)
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder builder = factory.newDocumentBuilder();
        FileInputStream xmlFile = new FileInputStream("C:\\netsong7\\JspWork\\EclipseWork\\AJAXApp\\src\\main\\webapp\\dom\\test.xml");
        Document doc = builder.parse(xmlFile); // 내가 가져온 xml을 트리에다 올려놓음
        
        Element root = doc.getDocumentElement();
        System.out.println(root.getNodeName());
        System.out.println(root.getNodeValue());
        System.out.println(root.getNodeType());
        System.out.println("===================================");
        
        // 문자/공백도 자식으로 받아서 node로 받게됨
        Node n1 = root.getFirstChild().getNextSibling();  // 
        System.out.println(n1.getNodeName());
        System.out.println(n1.getNodeValue());
        System.out.println(n1.getNodeType());
        System.out.println("===================================");
        
        Node n2 = root.getLastChild();  // -> 공백이 나옴(#text)
        System.out.println(n2.getNodeName());
        System.out.println(n2.getNodeValue());
        System.out.println(n2.getNodeType());
        System.out.println("===================================");
        
        //홍길동의 이름과 나이 출력
        System.out.println(n1.getFirstChild().getNextSibling().getNodeValue());
        System.out.println(n1.getLastChild().getPreviousSibling().getNodeValue());
    }

}
