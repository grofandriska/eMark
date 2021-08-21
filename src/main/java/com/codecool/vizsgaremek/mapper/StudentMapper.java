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
        StudentDto result = new StudentDto();
        result.setId(student.getId());
        result.setStudentClassId(student.getClassName().getId());
        result.setStudentName(student.getStudentName());
        result.setGender(student.getGender());
        return result;
    }

    public Student convertStudentDtoToEntity(StudentDto student) {
        Class classEntity = new Class();
        classEntity.setId(student.getStudentClassId());

        Student result = new Student();

        result.setId(student.getId());
        result.setClassName(classEntity);
        result.setStudentName(student.getStudentName());
        result.setGender(student.getGender());
        return result;
    }
}
