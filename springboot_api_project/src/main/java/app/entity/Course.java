package app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String course_name;
	String course_duration;

	@ManyToOne
	@JsonBackReference
	Student student;

	public Course() {

	}

	public Course(String course_name, String course_duration) {
		super();
		this.course_name = course_name;
		this.course_duration = course_duration;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", course_name=" + course_name + ", course_duration=" + course_duration + "]";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_duration() {
		return course_duration;
	}

	public void setCourse_duration(String course_duration) {
		this.course_duration = course_duration;
	}

}
