import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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

	@Override
	public String toString(){
		return "Authors: "+authors + " Title: "+title + " Date: "+date + " Pages: "+pages + " Volume: "+volume + " Journal/BookTitle: "+jourBook + " Year: "+year + " URL: "+ url;
	}

}


