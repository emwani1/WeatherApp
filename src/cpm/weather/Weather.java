package cpm.weather;

public class Weather {
	private String city;
	private String code;
	
	public Weather (String city, String code){
		this.city = city;
		this.code = code;
	}
	public Weather(String city){
		this.city = city;
		code = "us";
	}
	public void setCity(String city){
		this.city = city;
	}
	public void setCode (String code){
		this.code = code;
	}
	public String getCity(){
		return city;
	}
	public String getCode(){
		return code;
	}
}
