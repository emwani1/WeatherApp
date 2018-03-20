package cpm.weather;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

public class Clent {

	public static void main(String[] args) {
			Scanner console = new Scanner (System.in);
			System.out.println("Hello Welcome to the Weather Application");
			System.out.println("Enter the city name");
			String city = console.nextLine();
			Weather weather = new Weather(city);
			Request request = new Request(weather);
			request.run();     
	     }
		   
	}
		
	


