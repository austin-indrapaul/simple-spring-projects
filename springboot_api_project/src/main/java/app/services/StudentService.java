package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.entity.Course;
import app.entity.Student;
import app.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public ResponseEntity getAllStudents() {
		try {
			return new ResponseEntity(repository.findAll(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity saveStudent(Student student) {
		try {
			return new ResponseEntity(repository.save(student), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity("Unable to add student - invalid input\n\n" + e, HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity findStudent(int studentId) {
		Optional<Student> _student = repository.findById(studentId);
		if (_student.isPresent()) {
			return new ResponseEntity(_student.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity("Student record not found", HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity updateStudent(Student student, int student_id) {
		Optional<Student> _student = repository.findById(student_id);
		if (_student.isPresent()) {
			Student studentDB = _student.get();

			studentDB.setName(student.getName());
			studentDB.setAge(student.getAge());
			studentDB.setUsername(student.getUsername());
			studentDB.setPassword(student.getPassword());
			if (null != student.getAddress())
				studentDB.setAddress(student.getAddress());
			if (null != student.getCourses()) {
				for (Course course : student.getCourses()) {
					addCourse(student_id, course);
				}
			}

			return new ResponseEntity(repository.save(studentDB), HttpStatus.FOUND);
		} else {
			return new ResponseEntity("Student record not found", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity deleteStudent(int student_id) {
		try {
			repository.deleteById(student_id);
			return new ResponseEntity("Student record deleted successfully", HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity("Student record not found\n\n" + e, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity addCourse(int student_id, Course course) {
		Optional<Student> _student = repository.findById(student_id);
		if (_student.isPresent()) {
			Student studentDB = _student.get();
			studentDB.getCourses().add(course);
			return new ResponseEntity(repository.save(studentDB), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity("Student record not found", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity removeCourse(int student_id, int course_id) {
		Optional<Student> _student = repository.findById(student_id);
		if (_student.isPresent()) {
			Student studentDB = _student.get();
			Optional<Course> course = studentDB.getCourses().stream().filter(c -> c.getId() == course_id).findFirst();
			try {
				studentDB.getCourses().remove(course.get());
				return new ResponseEntity(repository.save(studentDB), HttpStatus.ACCEPTED);
			} catch (Exception e) {
				return new ResponseEntity("course not found\n\n" + e, HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity("Student record not found", HttpStatus.NOT_FOUND);
		}
	}

}
