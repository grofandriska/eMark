package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.dto.StudentDto;
import com.codecool.vizsgaremek.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("getAll")
    public List<StudentDto> getAllStudent() {
        return studentService.getAll();
    }

    @PostMapping("add")
    public void save(@RequestBody StudentDto student) {
        studentService.save(student);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/class/{id}")
    public List<StudentDto> getStudentsByClass(@PathVariable Long id) {
        return studentService.getStudentsByClassId(id);
    }

    @GetMapping("/gender/{gender}")
    public List<StudentDto> getStudentsGender(@PathVariable String gender) {
        return studentService.getStudentsByGender(gender);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

}
