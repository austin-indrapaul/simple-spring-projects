package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Course;
import app.entity.Student;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	public List<Course> findAll();

	public List<Course> findByStudent(Student student);
}
