package Scrapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.opencsv.CSVWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class pdfCrawler 
{

	public static void main(String[] args) 
	{
		
	    try 
	    {	
			String filepath = "pdfUrls.csv";
		    File file = new File(filepath);
		    FileWriter outputFile = new FileWriter(file);		    
		    CSVWriter csvwriter = new CSVWriter(outputFile); 
		    
		    
		    // Adding headers in csv files
		    String[] header = {"pdfUrl"};
		    csvwriter.writeNext(header);
		    
		    
		    // Url variables
		    ArrayList<String> urlList = new ArrayList<String>();
		    Set<String> urlSet = new HashSet<String>(), pdfSet = new HashSet<String>();
		    int urlCount = 0, pdf = 0;
	
		    // Adding seed url
			String seedUrl = "https://pec.ac.in/";
		    urlList.add(seedUrl);
		    urlSet.add(seedUrl);
		    
		    Document seed;
		    Elements links, iframe;
	
		    
		    urlCount = 0;
		    pdf = 0;
		    for(int i=0;i<urlList.size();i++) 
		    {
		    	if(i>=200) 
		    	{
		    		break;
		    	}
		    	try 
		    	{
		    		String currUrl = urlList.get(i);
//			    	System.out.println(currUrl);
	
			    	seed = Jsoup.connect(currUrl).get();
	
				    links = seed.select("a[href]");
				    for (Element link : links) {
				    	String Url;
				    	Url = link.absUrl("href");
				    	
				    	if(!urlSet.contains(Url) && Url.contains("https://pec.ac.in/") ) 
				    	{
				    		if(Url.endsWith(".pdf") && !pdfSet.contains(Url)) 
				    		{
						    	System.out.println(Url);
				    			csvwriter.writeNext(new String[] {Url});
				    			pdfSet.add(Url);
				    			pdf++;
				    		}
				    		else 
				    		{
						        urlList.add(Url);
						        urlSet.add(Url);
						        urlCount++;			    			
				    		}
				    	}
				    }
				    
				    iframe = seed.select("iframe");
				    for (Element frame : iframe) 
				    {
				    	String Url;
				    	Url = frame.attr("data-src");
				    	
				    	if(!urlSet.contains(Url) && Url.contains("https://pec.ac.in/") && Url.endsWith(".pdf")  && !pdfSet.contains(Url)) 
				    	{
				    		System.out.println(Url);
			    			csvwriter.writeNext(new String[] {Url});
			    			pdfSet.add(Url);
				    		pdf++;
				    	}
				    }
				    
	
		    	}
		    	catch(IOException e) 
		    	{
		    		e.printStackTrace();
		    	}
		    	System.out.println("Web pages searched, urls found, pdf found: " + (i+1) + " " + urlCount + " " + pdf);
		    }
		    System.out.println("Total webpages searched: 200");
		    System.out.println("Total links found: " + urlCount);
		    System.out.println("Total pdf found: " + pdf);
		    csvwriter.writeNext(new String[] {"Total pdf found: " + pdf});
		    csvwriter.close();
	    }
	    catch(IOException e) 
	    {
    		e.printStackTrace();
    	}		
		
	}

}
