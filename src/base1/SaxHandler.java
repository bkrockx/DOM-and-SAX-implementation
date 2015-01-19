package base1;

import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

import base.User;
import base1.SaxParser1;

public class SaxHandler extends DefaultHandler{
	
	List<User> userList = new ArrayList<>();
	User user = null;
	String content = null;
	
	@Override
	public void startElement(String uri,String LocalName,String qName,Attributes attributes) throws SAXException{
		while(qName.equalsIgnoreCase("user")){
			user = new User();
			user.id = attributes.getValue("id");
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName,String qName) throws SAXException {
		if(qName.equalsIgnoreCase("user")){
			userList.add(user);
		}
		else if(qName.equalsIgnoreCase("firstName")){
			user.firstName = content;
		}
		else if(qName.equalsIgnoreCase("lastName")){
			user.lastName = content;
		}
		else{
			user.location = content;
		}
	}

	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
	    content = String.copyValueOf(ch, start, length).trim();
	}

}
