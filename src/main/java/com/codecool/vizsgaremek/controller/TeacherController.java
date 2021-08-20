package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.TeacherDto;
import com.codecool.vizsgaremek.service.TeacherService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping("add")
    public void saveTeacher(@RequestBody TeacherDto teacher){
        teacherService.saveTeacher(teacher);
    }


    @GetMapping("getAll")
    public List<TeacherDto> getAllTeacher(){
        return teacherService.getAllTeacher();
    }


    @PutMapping("update/{id}")
    public void updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        teacherService.updateTeacherById(id,teacher);
    }

    @DeleteMapping("delete/{id}")
    public void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
    }

}
