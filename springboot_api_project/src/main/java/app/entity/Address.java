package app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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
