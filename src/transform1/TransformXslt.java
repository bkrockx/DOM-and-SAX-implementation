package transform1;
import java.io.IOException;
import java.util.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import base.*;
import base1.*;

public class TransformXslt {
	
	public static void main(String[] args){
		System.out.println("executing");
		Source xmlInput = new StreamSource("User.xml");
		Source xsl = new StreamSource("User.xsl");
		//Result xmlOutput = new StreamResult("output.xml");
		Result output = new StreamResult("output.html");
		
		try{
			Transformer transformer = TransformerFactory.newInstance().newTransformer(xsl);
			transformer.transform(xmlInput,output);
		}
		catch(TransformerException e){
			e.printStackTrace();
		}
	}
	
}
