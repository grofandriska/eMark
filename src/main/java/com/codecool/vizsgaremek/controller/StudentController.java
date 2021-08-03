package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.dto.StudentDto;
import com.codecool.vizsgaremek.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("addStudent")
    public void save(Student student) {
        studentService.save(student);
    }

    @PutMapping("/updateById/{id}")
    public void update(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping
    public void delete(Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping
    public List<StudentDto> getAllStudent() {
        return studentService.getAll();
    }

}