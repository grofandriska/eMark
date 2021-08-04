package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.dto.StudentDto;

import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentMapper() {
    }

    public StudentDto convertStudentToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setStudentClassId(student.getClassID().getId());
        studentDto.setStudentName(student.getStudentName());
        return studentDto;
    }

    public Student convertStudentDtoToEntity(StudentDto student) {
        Student studentEntity = new Student();
        studentEntity.setId(student.getId());
        studentEntity.setStudentName(student.getStudentName());
        Class classEntity = new Class();
        classEntity.setId(student.getStudentClassId());
        studentEntity.setClassID(classEntity);
        return studentEntity;
    }


}
