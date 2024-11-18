package com.eternity.SpringJDBC.repository;

import com.eternity.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public void save(Student s)
    {
        String sql = "Insert Into student (rollno, name, marks) Values (?,?,?) ;";
        int row = jdbc.update(sql, s.getRollno(), s.getName(), s.getMarks());

        System.out.println("Row Effected : "+row);
    }

    public List<Student> findAll()
    {

        String sql = "Select * From student ; ";
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                 Student s = new Student();
                 s.setRollno(rs.getInt("rollno"));
                 s.setName(rs.getString("name"));
                 s.setMarks(rs.getInt("marks"));

                 return s;
            }
        };

        return jdbc.query(sql,mapper);
    }
}
