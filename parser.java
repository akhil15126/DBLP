import java.util.*;
import java.io.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


class publication{
	private String date;
	private ArrayList<String> authors;
	private String title;
	private String pages;
	private String year;
	private String volume;
	private String jourBook;
	private ArrayList<String> url;

	public publication(){
		authors = new ArrayList<String>();
		url = new ArrayList<String>();
		// title = "";
		// pages = "";
		// year = "";
		// volume = "";
		// jourBook = "";
		// url = "";
	}

	public void setDate(String date){
		this.date = date;
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

	@Override
	public String toString(){
		return "Authors: "+authors + " Title: "+title + " Date: "+date + " Pages: "+pages + " Volume: "+volume + " Journal/BookTitle: "+jourBook + " Year: "+year + " URL: "+ url;
	}

}

class FileHandler extends DefaultHandler{
	private List<publication> mydata = null;
	private publication pub = null;

	public List<publication> getMyData(){
		return mydata;
	}
	//boolean bDate = false;
	boolean bAuthor = false;
	boolean bTitle = false;
	boolean bPages = false;
	boolean bVolume = false;
	boolean bYear = false;
	boolean bJourBook = false;
	boolean bURL = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if ((qName.equalsIgnoreCase("article")) || (qName.equalsIgnoreCase("proceedings")) || (qName.equalsIgnoreCase("inproceedings")) || (qName.equalsIgnoreCase("book")) || (qName.equalsIgnoreCase("incollection")) || (qName.equalsIgnoreCase("phdthesis")) || (qName.equalsIgnoreCase("masterthesis")) || (qName.equalsIgnoreCase("www")) ){
			String date = attributes.getValue("mdate");
			pub = new publication();
			pub.setDate(date);
			if(mydata == null){
				mydata = new ArrayList<>();
			}
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
		if ((qName.equalsIgnoreCase("article")) || (qName.equalsIgnoreCase("proceedings")) || (qName.equalsIgnoreCase("inproceedings")) || (qName.equalsIgnoreCase("book")) || (qName.equalsIgnoreCase("incollection")) || (qName.equalsIgnoreCase("phdthesis")) || (qName.equalsIgnoreCase("masterthesis")) || (qName.equalsIgnoreCase("www")) ){
			mydata.add(pub);
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

public class parser{
	public static void main(String[] args){
		//System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try{
			SAXParser saxParser = saxParserFactory.newSAXParser();
			FileHandler handler = new FileHandler();
			saxParser.parse(new File("dblp.xml"), handler);
			List<publication> mydata = handler.getMyData();
			for(publication pub : mydata){
				System.out.println(pub);
				System.out.println("\n");
			}
			//System.clearProperty("jdk.xml.entityExpansionLimit");
		}catch(ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}

	}
}


