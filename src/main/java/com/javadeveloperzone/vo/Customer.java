package com.javadeveloperzone.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "customer")
public class Customer {
   
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String name;
    private String describtion;

    public Customer() {  }

    public Customer(String name, String describtion) {
        this.name = name;
        this.describtion = describtion;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
}
