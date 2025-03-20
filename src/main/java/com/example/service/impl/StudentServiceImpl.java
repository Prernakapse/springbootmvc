package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return this.studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> s = studentRepository.findById(student.getId());
		if(s.isEmpty()) {
			return null;
		}
		else {
			return studentRepository.save(student);	
		}
	}

	@Override
	public String deleteStudentById(Integer id) {
		this.studentRepository.deleteById(id);
		return "Student deleted Successfully!!!";
		
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> s = studentRepository.findById(id);
		if(s.isEmpty()) {
			return null;
		}
		else {
			return s.get();
		}
	}

	@Override
	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

}
