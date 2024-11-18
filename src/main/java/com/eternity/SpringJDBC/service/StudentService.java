package com.eternity.SpringJDBC.service;

import com.eternity.SpringJDBC.model.Student;
import com.eternity.SpringJDBC.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s)
    {
        repo.save(s);
    }

    public void deleteStudent(int r)
    {
        repo.remove(r);
    }

    public List<Student> getStd()
    {
        return repo.findAll();
    }

}
