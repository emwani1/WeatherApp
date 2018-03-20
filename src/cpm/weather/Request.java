package cpm.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class Request {
	private Weather weather;
public Request(Weather weather){
	this.weather = weather;
}
public void run(){
	try{
		call();
	}catch(Exception e){
		e.printStackTrace();
	}
}
public void call() throws Exception {
	String city = weather.getCity();
	String code = weather.getCode();
	String key = "197c2b4e3f9c4e471bcdc088f1df8a13";
    String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+","+code+"&appid="+key;
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    // optional default is GET
    con.setRequestMethod("GET");
    //add request header
    con.setRequestProperty("User-Agent", "Mozilla/5.0");
    int responseCode = con.getResponseCode();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
    	response.append(inputLine);
    }
    in.close();
    //print in String
    //Read JSON response and print
    JSONObject myResponse = new JSONObject(response.toString());
    JSONArray arr = myResponse.getJSONArray("weather");
    String weather = "";
    String description = "";
    for(int i = 0; i < arr.length(); i++){
   	 weather = arr.getJSONObject(i).getString("main");
   	 description = arr.getJSONObject(i).getString("description");
    }
    System.out.println("Weather- "+weather);
    System.out.println("Description- "+description);
   
  }
}
