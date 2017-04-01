import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class NumHandler extends DefaultHandler{
	//private List<author_name> auth_list = new ArrayList<>();
	private HashMap<String, Integer> hm3 = new HashMap<String, Integer>();
	private publication pub;
	private Integer num_pub[];
	//private List<Integer> num_pub = new ArrayList<Integer>();
	private List<String> anl = new ArrayList<>();
	private List<String> final_authors = new ArrayList<>();

	private int count;
	

	// boolean bDate = false;
	boolean bAuthor = false;
	// boolean bTitle = false;
	// boolean bPages = false;
	// boolean bVolume = false;
	// boolean bYear = false;
	// boolean bJourBook = false;
	// boolean bURL = false;
	private int k;

	public NumHandler(HashMap<String, Integer> an , int num, int c, List<String> cc){
		anl = cc;
		//System.out.println(anl);
		this.k = num;
		hm3 = an;
		//System.out.println(hm3);
		count = c;
		//System.out.println(count);
		// System.out.println(anl.size());
		// System.out.println(anl);
		num_pub = new Integer[count+1];
		for(int i = 0; i<count+1 ; i++){
			//System.out.println("hey");
			num_pub[i]=0;
			//num_pub.add(0);
		}
		//System.out.println(num_pub);
	}


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if ((qName.equalsIgnoreCase("article")) || (qName.equalsIgnoreCase("proceedings")) || (qName.equalsIgnoreCase("inproceedings")) || (qName.equalsIgnoreCase("book")) || (qName.equalsIgnoreCase("incollection")) || (qName.equalsIgnoreCase("phdthesis")) || (qName.equalsIgnoreCase("masterthesis")) ){
			//String date = attributes.getValue("mdate");
			pub = new publication();
			//pub.setDate(date);
		} else if (qName.equalsIgnoreCase("author")){
			bAuthor = true;
		} //else if (qName.equalsIgnoreCase("title")){
		// 	bTitle = true;
		// } else if (qName.equalsIgnoreCase("pages")){
		// 	bPages = true;
		// } else if (qName.equalsIgnoreCase("volume")){
		// 	bVolume = true;
		// } else if (qName.equalsIgnoreCase("year")){
		// 	bYear = true;
		// } else if ((qName.equalsIgnoreCase("journal")) || (qName.equalsIgnoreCase("booktitle")) ){
		// 	bJourBook = true;
		// } else if (qName.equalsIgnoreCase("url")){
		// 	bURL = true;
		// }
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
		if ((qName.equalsIgnoreCase("article")) || (qName.equalsIgnoreCase("proceedings")) || (qName.equalsIgnoreCase("inproceedings")) || (qName.equalsIgnoreCase("book")) || (qName.equalsIgnoreCase("incollection")) || (qName.equalsIgnoreCase("phdthesis")) || (qName.equalsIgnoreCase("masterthesis"))){
			List<String> bb = pub.getAuthors();
			for(int i=0 ; i< bb.size() ; i++){
				String tmp=bb.get(i); 
				Integer tt=(Integer)hm3.get(tmp);
				//System.out.println(tmp+tt);
				//num_pub.add(tt, num_pub.get(tt)+1);
				if(!(tt==null)){
					//System.out.println("hey");
					num_pub[tt]++;
				}
			}
			// for(int j=0; j<count+1;j++){
			// 	System.out.println(num_pub[j]);
			// }
			//System.out.println(num_pub);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException{
		if(bAuthor){
			pub.setAuthors(new String(ch, start, length));
			bAuthor = false;
		} //else if(bTitle){
		// 	pub.setTitle(new String(ch, start, length));
		// 	bTitle = false;
		// } else if(bPages){
		// 	pub.setPages(new String(ch,start,length));
		// 	bPages = false;
		// } else if(bVolume){
		// 	pub.setVolume(new String(ch, start, length));
		// 	bVolume = false;
		// } else if(bYear){
		// 	pub.setYear(new String(ch, start, length));
		// 	bYear = false;
		// } else if(bJourBook){
		// 	pub.setJourBook(new String(ch, start, length));
		// 	bJourBook = false;
		// } else if(bURL){
		// 	pub.setURL(new String(ch, start, length));
		// 	bURL = false;
		// }
	}

	public List<String> getMyData(){
		for(int i=0 ; i< count+1 ; i++){
			if(num_pub[i] >= k){
			//if(num_pub.get(i) >= k){
				final_authors.add(anl.get(i));
			}
		}
		return final_authors;
	}
}
