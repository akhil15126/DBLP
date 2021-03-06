import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;




public class AuthHandler2 extends DefaultHandler{
	//private author_name author;
	//private List<author_name> authors_list = new ArrayList<>();
	private List<String> anl = new ArrayList<>();
	private HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
	int count = 0;
	boolean bAuthor = false;
	boolean bWWW = false;

	public HashMap<String, Integer> getMyData(){
		return hm2;
	}

	public int getCount(){
		return count - 1;

	}

	public List<String> getAnl(){
		return anl;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if ( qName.equalsIgnoreCase("www") ){
			bWWW = true;
			//author = new author_name();
			// if(authors_list == null){
			// 	authors_list = new ArrayList<>();
			// }
		} else if (qName.equalsIgnoreCase("author") && bWWW){
			bAuthor = true;
		} 
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
		if ( qName.equalsIgnoreCase("www") ){
			bWWW=false;
			if(anl.size()==count+1){
				count+=1;
			}
			//System.out.println(author);
			//authors_list.add(author);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException{
		if(bAuthor){
			String x = new String(ch, start, length);
			hm2.put(x, count);
			// if(count<=100){
			// System.out.println(count);
			// //System.out.println(anl.size());
			// System.out.println(x);
			// }
			if(anl.size() == count){
				// if(x.equals("")){
				// 	anl.add("null");
				// }
				// else{
				// }
					anl.add(x);
			}
			//author.addAuthName(new String(ch, start, length));
			bAuthor = false;
		}
	}


}
