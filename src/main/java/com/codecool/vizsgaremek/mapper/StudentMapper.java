package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    @Autowired
    ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StudentDto convertStudentToDto(Student student){
        return modelMapper.map(student, StudentDto.class);
    }

    public Student convertStudentDtoToEntity(StudentDto student){
        return modelMapper.map(student, Student.class);
    }



}
