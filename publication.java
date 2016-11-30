 import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
*publication class implementing comparable
*/
public class publication implements Comparable
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

	///constructor
	public publication(){
		authors = new ArrayList<String>();
		url = new ArrayList<String>();
		title = "";
		pages = "";
		year = "";
		volume = "";
		jourBook = "";
	}

	///date set
	public void setDate(String date){
		this.date = date;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try{
			mdate= df.parse(date);
		}
		catch(Exception e){}
	}

	///get Date format
	public Date getMdate(){
		return mdate;
	}

	///get String date
	public String getDate(){
		return date;
	}

	///add Authors
	public void setAuthors(String author){
		authors.add(author);
	}

	///get arraylist of authors
	public ArrayList<String> getAuthors(){
		return authors;
	}

	///set title
	public void setTitle(String title){
		this.title = title;
	}
	///get title
	public String getTitle(){
		return title;
	}

	///set pages
	public void setPages(String pages){
		this.pages = pages;
	}

	///get pages
	public String getPages(){
		return pages;
	}

	///set year
	public void setYear(String year){
		this.year = year;
	}

	///get year
	public String getYear(){
		return year;
	}
	///set volume
	public void setVolume(String volume){
		this.volume = volume;
	}
	///get volume
	public String getVolume(){
		return volume;
	}
	///set journal/booktitle
	public void setJourBook(String jourBook){
		this.jourBook = jourBook;
	}
	///get journal/booktitle
	public String getJourBook(){
		return jourBook;
	}
	///set url
	public void setURL(String url){
		this.url.add(url);
	}
	///get url
	public ArrayList<String> getURL(){
		return url;
	}
	///overriden compareTo method
	public int compareTo(Object c){
		publication b = (publication)c;
		String byear = b.getYear();
		if(Integer.parseInt(year)>Integer.parseInt(byear)){
			return -1;
		}
		else if(Integer.parseInt(year)==Integer.parseInt(byear)){
			return 0;
		}
		else{
			return 1;
		}


	}
	///overriden compareTo method
	@Override
	public String toString(){
		return "Authors: "+authors + " Title: "+title + " Date: "+date + " Pages: "+pages + " Volume: "+volume + " Journal/BookTitle: "+jourBook + " Year: "+year + " URL: "+ url;
	}

}


