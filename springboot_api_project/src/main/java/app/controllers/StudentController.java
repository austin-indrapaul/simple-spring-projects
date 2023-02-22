package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Course;
import app.entity.Student;
import app.services.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.SEE_OTHER)
	public String name() {
		return "welcome!!";
	}

	@GetMapping("/students")
	public ResponseEntity getAllStudent() {
		return studentService.getAllStudents();

	}

	@GetMapping("/student/{student_id}")
	public ResponseEntity getStudent(@PathVariable int student_id) {
		return studentService.findStudent(student_id);

	}

	@PostMapping("/student")
	public ResponseEntity addStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@PutMapping("/student/{student_id}")
	public ResponseEntity updateStudent(@PathVariable int student_id, @RequestBody Student student) {
		return studentService.updateStudent(student, student_id);
	}

	@DeleteMapping("/student/{student_id}")
	public ResponseEntity deleteStudent(@PathVariable int student_id) {
		return studentService.deleteStudent(student_id);
	}

	@GetMapping("/student/{student_id}/add-course")
	public ResponseEntity addCourse(@PathVariable int student_id, @RequestBody Course course) {
		return studentService.addCourse(student_id, course);
	}

	@GetMapping("/student/{student_id}/remove-course/{course_id}")
	public ResponseEntity removeCourse(@PathVariable int student_id, @PathVariable int course_id) {
		return studentService.removeCourse(student_id, course_id);
	}

}
