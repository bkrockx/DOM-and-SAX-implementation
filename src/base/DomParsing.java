package base;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.*;

import base.User;

public class DomParsing {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document =builder.parse("User.xml");

		
		List<User> userList = new ArrayList<>();
		
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		
		for(int i=0;i<nodeList.getLength();i++){
			Node node = nodeList.item(i);
			if(node instanceof Element){
				User user = new User();
				user.id = node.getAttributes().getNamedItem("id").getNodeValue();
				
				NodeList childNodes = node.getChildNodes();
				for(int j=0;j<childNodes.getLength();j++){
					Node cNode = childNodes.item(j);
					if(cNode instanceof Element){
						String content = cNode.getLastChild().getTextContent().trim();
						if(cNode.getNodeName().equalsIgnoreCase("firstName")){
							user.firstName = content;
						}
						else if(cNode.getNodeName().equalsIgnoreCase("LastName")){
							user.lastName = content;
						}
						else{
							user.location = content;
						}
					}
				}
				userList.add(user);
			}
		}
		
		for(User user:userList){
			System.out.println(user);
		}
		
	}

}
