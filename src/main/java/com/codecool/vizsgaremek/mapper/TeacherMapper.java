package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.TeacherDto;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public TeacherMapper() {
    }

    public TeacherDto convertTeacherToDto(Teacher teacher){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setName(teacher.getName());
        teacherDto.setSubject(teacher.getSubject());
        teacherDto.setGender(teacher.getGender());
        return teacherDto;
    }

    public Teacher convertTeacherDtoToEntity(TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setSubject(teacherDto.getSubject());
        teacher.setName(teacherDto.getName());
        teacher.setGender(teacherDto.getGender());
        return teacher;
    }

}
