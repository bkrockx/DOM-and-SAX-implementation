package validation;

import base.*;
import base1.*;
import validation.*;

import java.io.File;
import java.io.IOException;
 
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
 
import org.xml.sax.SAXException;

public class XsdValidation {
	
	public static void main(String[] args){
		boolean result = validateXmlSchema("User.xsd","User.xml");
		System.out.println("User.xml validates against User.xsd? "+ result);
	}
	
	public static boolean validateXmlSchema(String xsd,String xml){
		try{
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsd));
			
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xml)));
		}
		catch(IOException|SAXException e){
			System.out.println("exception"+ " "+e.getMessage());
			return false;
		}
		return true;
	}

}
