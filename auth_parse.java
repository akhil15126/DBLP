
import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;






public class auth_parse{
	public static void main(String[] args){
		String a = "Wei Wang";
		auth_search ab = new auth_search();
		ab.author_parse(a);
		List<publication> mydata = ab.getPublications();
		int i=0;
		for(publication pub : mydata){
			System.out.println(pub.getAuthors() + " ");
			i+=1;
		}
		System.out.println(i);
	}
}