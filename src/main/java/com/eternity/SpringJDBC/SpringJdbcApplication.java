package com.eternity.SpringJDBC;

import com.eternity.SpringJDBC.model.Student;
import com.eternity.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		Student s = context.getBean(Student.class);
		s.setRollno(161);
		s.setName("Sahil");
		s.setMarks(87);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);

		List<Student> st = service.getStd();
		System.out.println(st);

	}

}
