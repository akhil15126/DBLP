import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;





public class query2{
	private int k;
	private List<String> mydata;
	private List<String> anl;
	//private List<author_name> myauthors;
	private HashMap<String, Integer> hm = new HashMap<String, Integer>();
	private int count;

	public query2(){
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser = saxParserFactory.newSAXParser();
			AuthHandler2 handler = new AuthHandler2();
			saxParser.parse(new File("dblp.xml"), handler);
			hm = handler.getMyData();
			count = handler.getCount();
			anl = handler.getAnl();
			// System.out.println(hm);
			// System.out.println(count);
			//System.out.println(anl);
			System.clearProperty("jdk.xml.entityExpansionLimit");
		}
		catch(ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}

	}

	// public List<author_name> auth_gen(){

	// }

	public void k_parse(int num){
		// List<String> same_author = new ArrayList<String>();
		// author = search;
		// same_author.add(author);

		// for(int i=0; i < myauthors.size(); i++){
		// 	List<String> la = myauthors.get(i).getAuthNames();
		// 	for(int j=0; j < la.size() ; j++){
		// 		if(la.get(j).contains(author)){
		// 			for(int k=0; k < la.size() ; k++){
		// 				same_author.add(la.get(k));
		// 			}
		// 			break;
		// 		}
		// 	}
		// 	if(same_author.size()>1){
		// 		break;
		// 	}
		// }

		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory3 = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser3 = saxParserFactory3.newSAXParser();
			NumHandler handler3 = new NumHandler(hm,num,count,anl);
			saxParser3.parse(new File("dblp.xml"), handler3);
			mydata = handler3.getMyData();
			System.clearProperty("jdk.xml.entityExpansionLimit");
			//return myauthors;

		}
		catch(ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}

	}


	public List<String> getAuthorList(){
		return mydata;
	}


}

