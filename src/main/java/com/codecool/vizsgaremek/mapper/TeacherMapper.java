package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.TeacherDto;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public TeacherMapper() {
    }

    public TeacherDto convertTeacherToDto(Teacher param){
        TeacherDto result = new TeacherDto();
        result.setId(param.getId());
        result.setName(param.getName());
        result.setSubject(param.getSubject());
        result.setGender(param.getGender());
        return result;
    }

    public Teacher convertTeacherDtoToEntity(TeacherDto param){
        Teacher result = new Teacher();
        result.setId(param.getId());
        result.setSubject(param.getSubject());
        result.setName(param.getName());
        result.setGender(param.getGender());
        return result;
    }

}
