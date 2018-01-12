package com.dp3.domain;


import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "cellars")
public class Cellar {

	@Id
	@JsonProperty()
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private String id;
	private String cellarName;
	private String location;



	private String description;

	public Cellar() {
		super();
	}


	public Cellar(@JsonProperty("id")String id,  @JsonProperty("cellarName") String cellarName, @JsonProperty("location")String location, @JsonProperty("description") String description) {
		this.cellarName = cellarName;
		this.location = location;
		this.description = description;
		this.id = id;
	}

	public void setCellarName(String cellarName) {
		this.cellarName = cellarName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getCellarName() {
		return cellarName;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}
	
	

}
