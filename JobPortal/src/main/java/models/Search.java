package models;

import org.springframework.stereotype.Component;

@Component
public class Search {

	public String phrase;
	public String city;
	
	public String getPhrase() {
		return phrase;
	}
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
