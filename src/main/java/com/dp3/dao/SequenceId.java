package com.dp3.dao;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="sequence")
public class SequenceId {
	
	@Id
	private String id;
	private BigInteger seq;
	public BigInteger getSeq() {
		return seq;
	}
}
