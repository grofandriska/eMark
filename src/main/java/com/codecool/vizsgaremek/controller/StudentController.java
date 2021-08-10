package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.dto.StudentDto;
import com.codecool.vizsgaremek.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Add a student")
    @PostMapping("addStudent")
    public void save(@RequestBody StudentDto student) {
        studentService.save(student);
    }

    @Operation(summary = "Update a student by id")
    @PutMapping("/updateById/{id}")
    public void update(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }
    @Operation(summary = "Delete a student by id")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    @Operation(summary = "Get all student")
    @GetMapping("/getAllStudent")
    public List<StudentDto> getAllStudent() {
        return studentService.getAll();
    }

    @Operation(summary = "Get all student by class id")
    @GetMapping("/byClass/{id}")
    public List<StudentDto> getStudentsByClass(@PathVariable Long id) {
        return studentService.getStudentsByClassId(id);
    }
    @Operation(summary = "Get all student by gender")
    @GetMapping("/byGenre/{gender}")
    public List<StudentDto> getStudentsGender(@PathVariable String gender) {
        return studentService.getStudentsByGender(gender);
    }

}
