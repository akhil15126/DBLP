import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


/**
*query 1, by author name
*/
public class auth_search{
	private String author;
	private List<publication> mydata;
	private List<author_name> myauthors;

	///constructor
	public auth_search(){
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser = saxParserFactory.newSAXParser();
			AuthHandler handler = new AuthHandler();
			saxParser.parse(new File("sample.xml"), handler);
			myauthors = handler.getMyData();
			System.clearProperty("jdk.xml.entityExpansionLimit");
		}
		catch(ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}

	}

	// public List<author_name> auth_gen(){

	// }

	///parsing and returns the results according to query1 (b)
	public void author_parse(String search){
		List<String> same_author = new ArrayList<String>();
		author = search;
		same_author.add(author);

		for(int i=0; i < myauthors.size(); i++){
			List<String> la = myauthors.get(i).getAuthNames();
			for(int j=0; j < la.size() ; j++){
				if(la.get(j).contains(author)){
					for(int k=0; k < la.size() ; k++){
						same_author.add(la.get(k));
					}
					break;
				}
			}
			if(same_author.size()>1){
				break;
			}
		}

		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory2 = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser2 = saxParserFactory2.newSAXParser();
			NameHandler handler2 = new NameHandler(same_author);
			saxParser2.parse(new File("sample.xml"), handler2);
			mydata = handler2.getMyData();
			System.clearProperty("jdk.xml.entityExpansionLimit");
			//return myauthors;

		}
		catch(ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}

	}

	///returns the final result
	public List<publication> getPublications(){
		return mydata;
	}


}
