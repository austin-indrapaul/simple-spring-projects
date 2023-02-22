package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Course;
import app.entity.Student;
import app.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	public List<Course> getCoursesOfStudent(Student student) {
		return courseRepository.findByStudent(student);
	}

}
