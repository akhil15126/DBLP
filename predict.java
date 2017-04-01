import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class predict{
	public static void main(String[] args){
		String a = "Wei Wang";
		String b = "1995";
		query3 ab = new query3();
		ab.author_parse(a,b);
		int mydata = ab.getPredict();
		System.out.println(mydata);
		//System.out.println(i);
	}
}