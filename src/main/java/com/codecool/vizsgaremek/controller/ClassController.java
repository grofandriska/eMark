package com.codecool.vizsgaremek.controller;

import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.dto.ClassDto;
import com.codecool.vizsgaremek.service.ClassService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("addClass")
    public void add(@RequestBody ClassDto classEntity) {
        classService.addClass(classEntity);

    }

    @DeleteMapping("deleteClass/{id}")
    public void delete(@PathVariable("id") Long id) {
        classService.deleteClass(id);
    }

    @PutMapping("/updateClass/{id}")
    @Operation(summary = "Update a single class by id .")
    @ApiResponse(responseCode = "204",
            description = "Class is updated by id")
    public void update(@PathVariable Long id,
                       @RequestBody Class classEntity) {
        classService.updateClass(id, classEntity);
    }

    @GetMapping("getAllClass")
    @Operation(summary = "Get all class with name and id .")
    @ApiResponse(responseCode = "200",
            description = "Classes are listed from the list")
    public List<ClassDto> listAll() {
        return classService.listAllClass();
    }

    @GetMapping("getClassByName/{name}")
    public ClassDto getClassByName(@PathVariable("name") String name) {
        return classService.getClassByName(name);

    }

    @GetMapping("getClassById/{id}")
    public ClassDto getClassById (@PathVariable Long id){
        return classService.getClassById(id);

    }
}
