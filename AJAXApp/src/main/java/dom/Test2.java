package dom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Test2 {

    public static void main(String[] args) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new FileInputStream("C:\\netsong7\\JspWork\\EclipseWork\\AJAXApp\\src\\main\\webapp\\dom\\test.xml"));
        
        Element root = doc.getDocumentElement(); // -> <students>
        
        for(Node n = root.getFirstChild(); n!=null; n = n.getNextSibling()) {
            if(n.getNodeType() == Node.ELEMENT_NODE) { // 공백이 아닌 태그일 때(type == 1일때)
                Element e = doc.createElement("address"); // address라는 태그를 만들겠다
                Text t = doc.createTextNode("서울시 강남구");
                
                e.appendChild(t); // address tag 안에 text node 추가됨
                n.appendChild(e); // 현재 node 안에 address tag 추가
            }
        }
        
        // 홍길동의 주소
        System.out.println(root.getFirstChild().getNextSibling().getLastChild().getTextContent());
        
        // 수정한 내용을 실제 파일에 적용
        TransformerFactory transFactory = TransformerFactory.newInstance(); // 싱글톤 방식으로 객체 생성
        Transformer trans = transFactory.newTransformer();
        
        trans.setOutputProperty(OutputKeys.ENCODING, "utf-8"); // file의 encoding 형식 지정
        trans.setOutputProperty(OutputKeys.INDENT, "yes"); // 들여쓰기 여부
        
        DOMSource source = new DOMSource(doc); //원본 소스를
        StreamResult result = new StreamResult(new FileOutputStream("C:\\netsong7\\JspWork\\EclipseWork\\AJAXApp\\src\\main\\webapp\\dom\\test2.xml")); // 저장할 타겟 파일 경로 설정 -> 타겟 파일로 옮기겠다.
        
        trans.transform(source, result);
    }
    

}











