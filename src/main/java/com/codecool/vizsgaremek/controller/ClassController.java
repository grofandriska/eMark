package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.dto.ClassDto;
import com.codecool.vizsgaremek.service.ClassService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @Operation(summary = "Add a class")
    @PostMapping("addClass")
    public void add(@RequestBody ClassDto classEntity) {
        classService.addClass(classEntity);

    }
    @Operation(summary = "Delete a single class by id .")
    @DeleteMapping("deleteClass/{id}")
    public void delete(@PathVariable("id") Long id) {
        classService.deleteClass(id);
    }

    @PutMapping("/updateClass/{id}")
    @Operation(summary = "Update a single class by id .")
    public void update(@PathVariable Long id,
                       @RequestBody Class classEntity) {
        classService.updateClass(id, classEntity);
    }

    @GetMapping("getAllClass")
    @Operation(summary = "Get all class ")
    public List<ClassDto> listAll() {
        return classService.listAllClass();
    }

    @Operation(summary = "Get class by name")
    @GetMapping("getClassByName/{name}")
    public ClassDto getClassByName(@PathVariable("name") String name) {
        return classService.getClassByName(name);

    }
    @Operation(summary = "Get class by id")
    @GetMapping("getClassById/{id}")
    public ClassDto getClassById (@PathVariable Long id){
        return classService.getClassById(id);

    }
}
