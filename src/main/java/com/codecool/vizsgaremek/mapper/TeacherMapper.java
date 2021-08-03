package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.TeacherDto;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public TeacherMapper() {
    }

    public TeacherDto teacherToDto(Teacher teacher){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setName(teacher.getName());
        teacherDto.setSubject(teacher.getSubject());
        return teacherDto;
    }

    public Teacher teacherDtoToEntity(TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setSubject(teacherDto.getSubject());
        teacher.setName(teacherDto.getName());
        return teacher;
    }

}
