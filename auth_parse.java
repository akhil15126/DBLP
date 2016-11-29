import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


class publication implements Comparable
{
	private String date;
	private ArrayList<String> authors;
	private String title;
	private String pages;
	private String year;
	private String volume;
	private String jourBook;
	private ArrayList<String> url;
	private Date mdate;

	public publication(){
		authors = new ArrayList<String>();
		url = new ArrayList<String>();
		title = "";
		pages = "";
		year = "";
		volume = "";
		jourBook = "";
	}

	public void setDate(String date){
		this.date = date;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try{
			mdate= df.parse(date);
		}
		catch(Exception e){}
	}

	public Date getMdate(){
		return mdate;
	}

	public String getDate(){
		return date;
	}

	public void setAuthors(String author){
		authors.add(author);
	}

	public ArrayList<String> getAuthors(){
		return authors;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setPages(String pages){
		this.pages = pages;
	}

	public String getPages(){
		return pages;
	}


	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setVolume(String volume){
		this.volume = volume;
	}

	public String getVolume(){
		return volume;
	}

	public void setJourBook(String jourBook){
		this.jourBook = jourBook;
	}

	public String getJourBook(){
		return jourBook;
	}

	public void setURL(String url){
		this.url.add(url);
	}

	public ArrayList<String> getURL(){
		return url;
	}
	
	public int compareTo(Object c){
		publication b = (publication)c;
		String bYear = b.getYear();
		if(Integer.parseInt(year) > Integer.parseInt(bYear)){
			return -1;
		}
		else if(Integer.parseInt(year) == Integer.parseInt(bYear)){
			return 0;
		}
		else{
			return 1;
		}


	}

	@Override
	public String toString(){
		return "Authors: "+authors + " Title: "+title + " Date: "+date + " Pages: "+pages + " Volume: "+volume + " Journal/BookTitle: "+jourBook + " Year: "+year + " URL: "+ url;
	}

}


class NameHandler extends DefaultHandler{
	private List<publication> mydata = new ArrayList<>();
	private publication pub;

	public List<publication> getMyData(){
		return mydata;
	}
	boolean bDate = false;
	boolean bAuthor = false;
	boolean bTitle = false;
	boolean bPages = false;
	boolean bVolume = false;
	boolean bYear = false;
	boolean bJourBook = false;
	boolean bURL = false;
	private List<String> names;

	public NameHandler(List<String> search){
		this.names = search;
	}


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if ((qName.equalsIgnoreCase("article")) || (qName.equalsIgnoreCase("proceedings")) || (qName.equalsIgnoreCase("inproceedings")) || (qName.equalsIgnoreCase("book")) || (qName.equalsIgnoreCase("incollection")) || (qName.equalsIgnoreCase("phdthesis")) || (qName.equalsIgnoreCase("masterthesis")) ){
			String date = attributes.getValue("mdate");
			pub = new publication();
			pub.setDate(date);
		} else if (qName.equalsIgnoreCase("author")){
			bAuthor = true;
		} else if (qName.equalsIgnoreCase("title")){
			bTitle = true;
		} else if (qName.equalsIgnoreCase("pages")){
			bPages = true;
		} else if (qName.equalsIgnoreCase("volume")){
			bVolume = true;
		} else if (qName.equalsIgnoreCase("year")){
			bYear = true;
		} else if ((qName.equalsIgnoreCase("journal")) || (qName.equalsIgnoreCase("booktitle")) ){
			bJourBook = true;
		} else if (qName.equalsIgnoreCase("url")){
			bURL = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
		if ((qName.equalsIgnoreCase("article")) || (qName.equalsIgnoreCase("proceedings")) || (qName.equalsIgnoreCase("inproceedings")) || (qName.equalsIgnoreCase("book")) || (qName.equalsIgnoreCase("incollection")) || (qName.equalsIgnoreCase("phdthesis")) || (qName.equalsIgnoreCase("masterthesis"))){
			List<String> bb = pub.getAuthors();
			int check;
			for(int i=0; i < bb.size() ; i++){
				check =0;
				for(int k=0; k < names.size() ; k++){
					if(bb.get(i).contains(names.get(k))){
						mydata.add(pub);
						check = 1;
						break;
					}
				}
				if(check==1){
					break;
				}
			}
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException{
		if(bAuthor){
			pub.setAuthors(new String(ch, start, length));
			bAuthor = false;
		} else if(bTitle){
			pub.setTitle(new String(ch, start, length));
			bTitle = false;
		} else if(bPages){
			pub.setPages(new String(ch,start,length));
			bPages = false;
		} else if(bVolume){
			pub.setVolume(new String(ch, start, length));
			bVolume = false;
		} else if(bYear){
			pub.setYear(new String(ch, start, length));
			bYear = false;
		} else if(bJourBook){
			pub.setJourBook(new String(ch, start, length));
			bJourBook = false;
		} else if(bURL){
			pub.setURL(new String(ch, start, length));
			bURL = false;
		}
	}
}

class author_name{
	private ArrayList<String> names;

	public author_name(){
		names = new ArrayList<String>();
	}

	public void addAuthName(String name){
		names.add(name);
	}

	public ArrayList<String> getAuthNames(){
		return names;
	}

	@Override
	public String toString(){
		return "Author Names:" + names;
	}

}

class AuthHandler extends DefaultHandler{
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

class auth_search{
	private String author;
	private List<publication> mydata;
	private List<author_name> myauthors;
	public auth_search(){
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
			saxParser2.parse(new File("dblp.xml"), handler2);
			mydata = handler2.getMyData();
			System.clearProperty("jdk.xml.entityExpansionLimit");
			//return myauthors;

		}
		catch(ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}

	}


	public List<publication> getPublications(){
		return mydata;
	}


}


class auth_parse{
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