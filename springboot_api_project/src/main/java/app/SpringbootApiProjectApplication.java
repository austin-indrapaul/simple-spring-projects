package app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.entity.Address;
import app.entity.Course;
import app.entity.Student;
import app.repository.CourseRepository;
import app.repository.StudentRepository;

@SpringBootApplication
public class SpringbootApiProjectApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		studentRepository
				.save(new Student("John Doe", 21, "john", "123", new Address("AF1", "Marshal st", "NYC", "NY004")));

		Student student1 = studentRepository.findById(1).get();

		Course course = new Course("Communication", "120 mins");
		course.setStudent(student1);
		courseRepository.save(course);
		course = new Course("Professional Ethics", "100 mins");
		course.setStudent(student1);
		courseRepository.save(course);

		Student student2 = new Student("Jane Hog", 20, "jane", "123", new Address("CG4", "Juliete st", "NYC", "NY003"));
		student2.setCourses(Arrays.asList(new Course("Interpersonal skills", "90 mins"),
				new Course("Professional Ethics", "100 mins")));
		studentRepository.save(student2);
	}

}
