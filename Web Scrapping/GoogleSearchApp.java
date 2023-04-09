/*WHAT IS WEB SCRAPPING
   Web scraping is the process of collecting structured web data in an automated fashion.
   It's also called web data extraction. Some of the main use cases of web scraping include
   price monitoring, price intelligence, news monitoring, lead generation, and market research among many others.
*/

/*FEATURES OF JSOUP :-
 1)scrape and parse HTML from a URL, file, or string.
2)find and extract data, using DOM traversal or CSS selectors.
3)manipulate the HTML elements, attributes, and text.
4)clean user-submitted content against a safe white-list, to prevent XSS attacks.
5)output tidy HTML.
*/

package com.google.search;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;

import javax.swing.text.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoogleSearchApp {

	public static void main(String[] args) throws Exception{
		
		//GET THE KEYWORD
		Scanner sc=new Scanner(System.in);
		System.out.println("Please provide the keyword : ");
		String keyword=sc.nextLine();
		
		//SEARCH OVER YOUR PREFERRED SEARCH ENGINE
		
		String url="https://www.google.com/search"+"?q="+keyword;
		
		Document doc= Jsoup.connect(url).get();
		
		String html=doc.html();
		Files.write(Paths.get("H:\\My Projects\\Web Scrapping\\files.html"),html.getBytes());
		
		Elements links=doc.select("cite");
		
		for(org.jsoup.nodes.Element link : links) {
			System.out.println(link.text());
		}
		
		sc.close();
		
	}

}
