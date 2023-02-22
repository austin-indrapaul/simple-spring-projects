package app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Optional<Student> findById(Integer id);

}
