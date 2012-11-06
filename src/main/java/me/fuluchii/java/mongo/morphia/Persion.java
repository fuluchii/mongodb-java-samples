package me.fuluchii.java.mongo.morphia;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Persion {
	@Id private ObjectId id;
	private String name;
	@Embedded
	private Address address;
	
	public Persion(){
		
	}

    public Persion(String fullName, Address newAddress) {
        this.address = newAddress;
        this.name = fullName;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
    
}
