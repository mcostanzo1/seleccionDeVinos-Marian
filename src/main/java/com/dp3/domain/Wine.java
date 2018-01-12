package com.dp3.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wines")
public class Wine extends Stock {


	private String wineName;
	private int quantityOnBox;
	private String clasify;
	private String cellarName;


	public Wine() {
	}


	public Wine(String wineName, int quantityOnBox, String clasify, String cellarName) {
		this.wineName = wineName;
		this.quantityOnBox = quantityOnBox;
		this.clasify = clasify;
		this.cellarName = cellarName;
	}


	public String getWineName() {
		return wineName;
	}

	public void setWineName(String wineName) {
		this.wineName = wineName;
	}

	public int getQuantityOnBox() {
		return quantityOnBox;
	}

	public void setQuantityOnBox(int quantityOnBox) {
		this.quantityOnBox = quantityOnBox;
	}

	public String getClasify() {
		return clasify;
	}

	public void setClasify(String clasify) {
		this.clasify = clasify;
	}

	public String getCellarName() {
		return cellarName;
	}

	public void setCellar(String cellarName) {
		this.cellarName = cellarName;
	}
}
