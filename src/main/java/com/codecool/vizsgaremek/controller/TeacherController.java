package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.TeacherDto;
import com.codecool.vizsgaremek.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Operation(summary = "Add a teacher")
    @PostMapping("addTeacher")
    public void saveTeacher(@RequestBody TeacherDto teacher){
        teacherService.saveTeacher(teacher);
    }

    @Operation(summary = "Get all class")
    @GetMapping("getAllTeacher")
    public List<TeacherDto> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @Operation(summary = "Update a teacher by id")
    @PutMapping("updateTeacher/{id}")
    public void updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        teacherService.updateTeacherById(id,teacher);
    }

    @Operation(summary = "Delete a teacher by id")
    @DeleteMapping("deleteTeacher/{id}")
    public void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
    }

}
