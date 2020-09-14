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


public class focusedCrawler {

	public static void main(String[] args) {
		
		try {
		    
		    // CSV file for urls and page tag and text
		    String filepathUrl = "furls.csv", filepathText = "ftext.csv";
		    File fileUrl = new File(filepathUrl), fileText = new File(filepathText);
		    FileWriter outputFileUrl = new FileWriter(fileUrl), outputFileText = new FileWriter(fileText);		    
		    CSVWriter csvwriterUrl = new CSVWriter(outputFileUrl), csvwriterText = new CSVWriter(outputFileText); 
		    
		    
		    // Adding headers in csv files
		    String[] headerUrl = {"Text", "Url"}, headerText = {"Tag", "Text"};
		    csvwriterUrl.writeNext(headerUrl);  
		    csvwriterText.writeNext(headerText);
		    
		    
		    // Url variables
		    ArrayList<String> urlList = new ArrayList<String>();
		    Set<String> urlSet = new HashSet<String>();
		    int urlCount = 1;
	
	
		    // Getting all urls from seed
		    ArrayList<String> urlList1 = new ArrayList<String>();

		    
		    // Adding seed url
			String seedUrl = "https://pec.ac.in/cse";
//			urlList1.add("");
		    urlList.add(seedUrl);
		    urlSet.add(seedUrl);
		    
		    Document seed;
		    Elements links;
//		    int depth = 0;
			
			
		    System.out.println("Total links received from seed: " + urlList1.size());
		    
		    
		    System.out.println("Forming initial faculty pages list...");
		    System.out.println("Total depth to cover: 6");
		    urlCount = 0;
		    for(int i=0;i<urlList.size();i++) {
//		    	System.out.println(urlList1.get(i));
//		    	System.out.println(i);
		    	if(urlCount>=1000) {
		    		break;
		    	}
		    	try {
		    		String currUrl = urlList.get(i);
			    	System.out.println(currUrl);
//		    		if(currUrl.equals("")) {
//		    			urlList1.add("");
//		    			depth += 1;
//		    			System.out.println("Current Depth: " + depth);
//		    			System.out.println("Urls Scrapped: " + (i+1-depth));
//		    			continue;
//		    		}
//
		    		seed = Jsoup.connect(currUrl).get();

				    links = seed.select("a[href]");
				    for (Element link : links) {
				    	String Url;
				    	Url = link.absUrl("href");
				    	
				    	if(!urlSet.contains(Url) && Url.contains("https://pec.ac.in/")) {
					        urlList.add(Url);
					        urlSet.add(Url);
					        urlCount++;
				    	}
				    }

		    	}
		    	catch(IOException e) {
		    		e.printStackTrace();
		    	}
		    	System.out.println(urlCount);
		    }
		    System.out.println("Total urls obtained: " + urlList.size());
		    
		    
		    String currUrl;
	
		    urlCount = 0;
		    for(int i=0;i<urlList.size(); i++) {
	
				try {
			    	
			    	// Getting contents of seed url
					currUrl = urlList.get(i);
				    seed = Jsoup.connect(currUrl).get();
				    
				    // get the page title
				    String title = seed.title();
//				    System.out.println("title: " + title);
				    
				    
				    
				    // get all links in page
				    links = seed.select("a[href]");
				    for (Element link : links) {
				        // get the value from the href attribute
				    	String Url, urlText;
				    	Url = link.absUrl("href");
				    	urlText = link.text();
				    	
				    	if((!urlSet.contains(Url)) && Url.contains("https://pec.ac.in/") && urlText.length()>0  && Url.contains("faculty")) {
	//				        System.out.println("\nlink: " + Url);
	//				        System.out.println("text: " + urlText);
					        csvwriterUrl.writeNext(new String[] {urlText, Url });
					        urlSet.add(Url);
					        urlList.add(Url);
					        urlCount++;
				    	}
				    }
				    System.out.println(currUrl + " " + i);
				    
				    if(currUrl.contains("faculty")) {
					    // get all links in page
					    Elements para = seed.select("p");
					    for (Element p : para) {
					        // get the value from the href attribute
					    	String text;
					    	text = p.text();
		//			        System.out.println("p: " + text);
					    	if(text.length()>2) {
						        csvwriterText.writeNext(new String[] {"p", text});			    		
					    	}
					    }
					    
					    Elements h1 = seed.select("h1");
					    for (Element h : h1) {
					        // get the value from the href attribute
					    	String text;
					    	text = h.text();
		//			        System.out.println("h1: " + text);
					    	if(text.length()>0) {
						        csvwriterText.writeNext(new String[] {"h1", text});
					    	}
					    }
		
					    Elements h2 = seed.select("h2");
					    for (Element h : h2) {
					        // get the value from the href attribute
					    	String text;
					    	text = h.text();
		//			        System.out.println("h2: " + text);
					    	if(text.length()>0) {
					    		csvwriterText.writeNext(new String[] {"h2", text});
					    	}
					    }
		
					    Elements h3 = seed.select("h3");
					    for (Element h : h3) {
					        // get the value from the href attribute
					    	String text;
					    	text = h.text();
		//			        System.out.println("h3: " + text);
					    	if(text.length()>0) {
					    		csvwriterText.writeNext(new String[] {"h3", text});
					    	}
					    }
		
					    Elements h4 = seed.select("h4");
					    for (Element h : h4) {
					        // get the value from the href attribute
					    	String text;
					    	text = h.text();
		//			        System.out.println("h4: " + text);
					    	if(text.length()>0) {
					    		csvwriterText.writeNext(new String[] {"h4", text});
					    	}
					    }
					    
					    Elements img = seed.select("img");
					    for (Element im : img) {
					        // get the value from the href attribute
					    	String text, src;
					    	text = im.text();
					    	src = im.attr("src");
		//			        System.out.println("image: " + text);
		//			        System.out.println("source: " + src);
					    	if(text.length()>0 && src.length()>0) {
					    		csvwriterText.writeNext(new String[] {"img", src});
					    	}
					    }
				    	
						System.out.println("Current Url Count: " + (i+1));
						System.out.println("Current Url: " + currUrl);
						System.out.println();
						csvwriterText.writeNext(new String[] {""});
				    }
				    
				}
				
			    catch (IOException e) {
			    	e.printStackTrace();
			    }
				
				if(i==99) {
					csvwriterUrl.writeNext(new String[] {"Total urls brought: " + urlCount});
					csvwriterText.writeNext(new String[] {"Total urls text scraped: " + (i+1)});
					break;
				}
			}
		    csvwriterText.close();
		    csvwriterUrl.close();

		    System.out.println("Total urls scraped: 15" );
			System.out.println("Total urls brought: " + urlCount );

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
