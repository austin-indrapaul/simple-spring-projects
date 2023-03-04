package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private int age;

	@Column(unique = true)
	private String username;

	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id")
	// @JsonManagedReference
	public Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	// @JsonManagedReference
	List<Course> courses;

	public Student() {
	}

	public Student(String name, int age, String username, String password, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.username = username;
		this.password = password;
		this.address = address;
		this.courses = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", username=" + username + ", password="
				+ password + ", address=" + address + ", courses=" + courses + "]";
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
