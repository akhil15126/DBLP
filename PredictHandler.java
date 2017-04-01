import java.util.*;
import java.io.*;
import java.text.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class PredictHandler extends DefaultHandler{
	private List<publication> mydata = new ArrayList<>();
	private publication pub;

	public int getPrediction(){
		return mydata.size();
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
	private int year_check;

	public PredictHandler(List<String> search, String year){
		this.names = search;
		if(Integer.parseInt(year) == 2016){
			year_check = Integer.parseInt(year);
		}
		else{
			year_check = Integer.parseInt(year) + 1;}

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
			if(!(pub.getYear().equals("")))
				// String dd = pub.getYear();
				// int yy = Integer.parseInt(dd);
				if(Integer.parseInt(pub.getYear()) == year_check){
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

	public double myprediction()
	{
	int i;
double sum=0, mean=0, var=0;
for(i=0;i<mydata.size();i++)
{
sum+=Integer.parseInt(mydata.get(i).getVolume());
var+=Integer.parseInt(mydata.get(i).getVolume())*Integer.parseInt(mydata.get(i).getVolume());

}
mean=sum/mydata.size();
var=var/mydata.size();
double l=var-2.58*(mean);
double r=var+2.58*(mean);
return (l*l/4+r*r/4);

	}


}
