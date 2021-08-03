package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.TeacherDto;
import com.codecool.vizsgaremek.service.TeacherService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("addTeacher")
    public void saveTeacher(Teacher teacher){
        teacherService.saveTeacher(teacher);
    }

    @GetMapping("getAllTeacher")
    public List<TeacherDto> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @GetMapping("updateTeacher/{id}")
    public void updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        teacherService.updateTeacherById(id,teacher);
    }

    @DeleteMapping("deleteTeacher/{id}")
    public void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
    }

}
