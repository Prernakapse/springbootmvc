package com.example.service;

import java.util.List;

import com.example.entity.Student;

public interface StudentService {

	Student addStudent(Student student);
	Student updateStudent(Student student);
	String deleteStudentById(Integer id);
	Student getStudentById(Integer id);
	List<Student> getAllStudents();
}
