package traversal;

import base.*;
import base1.*;
import transform1.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
 




import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TraverseXpath {
	
	public static void main(String[] args){
		
		try{
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			
			Document xmlDocument = builder.parse("User.xml");
			
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expr = "/users/user";
			NodeList nodeList = (NodeList) xPath.compile(expr).evaluate(xmlDocument, XPathConstants.NODESET);
			
			List<User> userList = new ArrayList<>();
			
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
				System.out.println("nextUser");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
