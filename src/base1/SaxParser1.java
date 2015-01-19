package base1;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import base.User;
import base1.SaxHandler;


public class SaxParser1 {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		SaxHandler handler = new SaxHandler();
		
		parser.parse("User.xml",handler);

		
		for(User user1:handler.userList){
			System.out.println(user1);
		}
		
	}
}