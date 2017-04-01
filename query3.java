import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class query3{
	private String author;
	private int myPred;
	private List<author_name> myauthors;
	public query3(){
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser = saxParserFactory.newSAXParser();
			AuthHandler handler = new AuthHandler();
			saxParser.parse(new File("dblp.xml"), handler);
			myauthors = handler.getMyData();
			System.clearProperty("jdk.xml.entityExpansionLimit");
		}
		catch(ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}

	}

	// public List<author_name> auth_gen(){

	// }

	public void author_parse(String search, String predic){
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
/*System.out.println(predic);
					if(predic.equals("2016"))
{
predic="2015";
System.out.println("Done");
}*/

		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory2 = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser2 = saxParserFactory2.newSAXParser();
			PredictHandler handler2 = new PredictHandler(same_author, predic);
			saxParser2.parse(new File("dblp.xml"), handler2);
			myPred = handler2.getPrediction();
			System.clearProperty("jdk.xml.entityExpansionLimit");
			//return myauthors;

		}
		catch(ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}

	}


	public int getPredict(){
		return myPred;
	}


}
