import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class title_search{
	private String title;
	private List<publication> mydata;
	public title_search(String search){
		title= search;
	}
	public void title_parse(){
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser = saxParserFactory.newSAXParser();
			TitleHandler handler = new TitleHandler(title);
			mydata= new ArrayList<publication>();
			saxParser.parse(new File("sample.xml"), handler);
			mydata = handler.getMyData();
			// for(publication pub : mydata){
			// 	System.out.println(pub);
			// 	System.out.println("\n");
			// }
			System.clearProperty("jdk.xml.entityExpansionLimit");
		}catch(ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}

	}

	public List<publication> getPublications(){
		return mydata;
	}
}


