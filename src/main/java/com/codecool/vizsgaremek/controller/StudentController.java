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

    @PostMapping("addStudent")
    public void save(@RequestBody StudentDto student) {
        studentService.save(student);
    }

    @PostMapping("/updateById/{id}")
    public void update(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/getAllStudent")
    public List<StudentDto> getAllStudent() {
        return studentService.getAll();
    }

    @GetMapping("/byClass/{id}")
    public List<StudentDto> getStudentsByClass(@PathVariable Long id) {
        return studentService.getStudentsByClassId(id);
    }

    @GetMapping("/byGenre/{gender}")
    public List<StudentDto> getStudentsGender(@PathVariable String gender) {
        return studentService.getStudentsByGender(gender);
    }

}
