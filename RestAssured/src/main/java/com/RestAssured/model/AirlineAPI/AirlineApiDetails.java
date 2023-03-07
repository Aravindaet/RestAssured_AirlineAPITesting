package com.RestAssured.model.AirlineAPI;

import com.github.javafaker.Faker;

public class AirlineApiDetails {

	private int id;
	private String name;
	private String country;
	private String logo;
	private String slogan;
	private String head_quarters;
	private String website;
	private String established;

	static Faker faker = new Faker();

	public AirlineApiDetails() {
		id = readId();
		name = readName();
		country = readCountry();
		logo = readLogo();
		slogan = readSlogan();
		head_quarters = readHead_quarters();
		website = readWebsite();
		established = readEstablished();
	}

	public int getId() {
		return id;
	}

	private int readId() {
		int id = faker.number().numberBetween(35000, 50000);
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String readName() {
		String name = faker.name().fullName();
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String readCountry() {
		String country = faker.address().country();
		return country;
	}

	public String getLogo() {
		return logo;
	}

	public String readLogo() {
		String logo = "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png";
		return logo;
	}

	public String getSlogan() {
		return slogan;
	}

	public String readSlogan() {
		String slogan = "From" + " " + faker.address().country() + " " + "Airways";
		return slogan;
	}

	public String getHead_quarters() {
		return head_quarters;
	}

	public String readHead_quarters() {
		String head_quarters = faker.address().cityName();
		return head_quarters;
	}

	public String getWebsite() {
		return website;
	}

	public String readWebsite() {
		String website = "www.srilankaairways.com";
		return website;
	}

	public String getEstablished() {
		return established;
	}

	public String readEstablished() {
		int year = faker.number().numberBetween(1990, 2000);
		String established = String.valueOf(year);
		return established;
	}

}
