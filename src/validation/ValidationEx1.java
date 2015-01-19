package validation;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.InputSource;

import base.*;
import base1.*;

public class ValidationEx1 {
	
	private ValidationEx1(){}
	
	
	public static boolean validationUsingDom(String xml) throws ParserConfigurationException,IOException{
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			builder.setErrorHandler(new ErrorHandler(){
				public void warning(SAXParseException e) throws SAXException{
					System.out.println("WARNING : " + e.getMessage());
				}
				
				public void error(SAXParseException e) throws SAXException {
		              System.out.println("ERROR : " + e.getMessage());
		              throw e;
		        }

				public void fatalError(SAXParseException e) throws SAXException {
					System.out.println("FATAL : " + e.getMessage());
		            throw e;
				}
			});
			
			builder.parse(new InputSource(xml));
			return true;
		}
		catch (ParserConfigurationException e) {
			throw e;
		} 
		catch (IOException io) {
			throw io;
		}
		catch (SAXException se){
			return false;
		}
	}
	
	
	public static boolean validateUsingSAX(String xml) throws ParserConfigurationException, IOException{
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			reader.setErrorHandler(new ErrorHandler(){
				public void warning(SAXParseException e) throws SAXException {
					System.out.println("WARNING : " + e.getMessage()); // do nothing
		        }

		        public void error(SAXParseException e) throws SAXException {
		        	System.out.println("ERROR : " + e.getMessage());
		        	throw e;
		        }

		        public void fatalError(SAXParseException e) throws SAXException {
		        	System.out.println("FATAL : " + e.getMessage());
		        	throw e;
		        }
			});
			
			reader.parse(new InputSource(xml));
			return true;
		}
		catch(ParserConfigurationException pe){
			throw pe;
		}
		catch(IOException io){
			throw io;
		}
		catch(SAXException se){
			return false;
		}
		
	}
	
	public static void main(String args[]) throws Exception{
		
		ValidationEx1 v = new ValidationEx1();
		System.out.println(v.validationUsingDom("User.xml"));
		System.out.println(v.validateUsingSAX("User.xml"));
	}

}
