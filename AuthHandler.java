import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AuthHandler extends DefaultHandler{
	private author_name author;
	private List<author_name> authors_list = new ArrayList<>();
	boolean bAuthor = false;
	boolean bWWW = false;

	public List<author_name> getMyData(){
		return authors_list;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if ( qName.equalsIgnoreCase("www") ){
			bWWW = true;
			author = new author_name();
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
			//System.out.println(author);
			authors_list.add(author);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException{
		if(bAuthor){
			author.addAuthName(new String(ch, start, length));
			bAuthor = false;
		}
	}


}
