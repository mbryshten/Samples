package mbryshten.blockingqueue;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class Strings {

	public static void main(String[] args) throws XPathExpressionException {

		String s = "s";
		
		System.out.println(s);
		
		Integer i = null;
		
		System.out.println(String.valueOf(i));
		
		
		String xml = "<car><manufacturer>toyota</manufacturer></car>";
        String xpath = "/car/manufacturer";
        XPath xPath = XPathFactory.newInstance().newXPath();
        
        String xxx = xPath.evaluate(xpath, new InputSource(new StringReader(xml)));
        
        System.out.println(xxx);
	}

}
