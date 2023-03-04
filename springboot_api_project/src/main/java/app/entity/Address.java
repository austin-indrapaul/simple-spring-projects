package app.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@javax.persistence.Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
	int id;

	@JsonProperty
	String house_no;

	@JsonProperty
	String street;

	@JsonProperty
	String city;

	@JsonProperty
	String pincode;

	@OneToOne(mappedBy = "address")
	@JsonBackReference
	Student student;

	public Address() {

	}

	public Address(String house_no, String street, String city, String pincode) {
		super();
		this.house_no = house_no;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", house_no=" + house_no + ", street=" + street + ", city=" + city + ", pincode="
				+ pincode + "]";
	}

}
