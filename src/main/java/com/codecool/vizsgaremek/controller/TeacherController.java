package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.service.TeacherService;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("add")
    public Teacher saveTeacher(@Valid @RequestBody Teacher teacher, BindingResult bindingResult) {
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("getAll")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @PutMapping("update/{id}")
    public void updateTeacher(@PathVariable Long id, @Valid @RequestBody Teacher teacher, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult
                    .getAllErrors()
                    .forEach(errorObj -> System.out.println(errorObj.getDefaultMessage()));
        }
        teacherService.updateTeacherById(id, teacher);
    }

    @DeleteMapping("delete/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }
}
