package com.codecool.vizsgaremek.mapper;

import com.codecool.vizsgaremek.modell.Mark;
import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.MarkDto;
import org.springframework.stereotype.Component;

@Component
public class MarkMapper {
    public MarkMapper() {
    }

    public MarkDto convertMarkToDto(Mark markParameter){
        MarkDto result = new MarkDto();
        result.setMarkId(markParameter.getId());
        result.setStudentId(markParameter.getStudent().getId());
        result.setTeacherId(markParameter.getTeacher().getId());
        result.setMonth(markParameter.getMonth());
        result.setMark(markParameter.getMark());
        result.setSubject(markParameter.getSubject());
        return result;
    }

    public Mark convertMarkDtoToEntity(MarkDto markParameter){
        Mark result = new Mark();
        result.setId(markParameter.getMarkId());
        result.setMark(markParameter.getMark());
        result.setMonth(markParameter.getMonth());
        result.setSubject(markParameter.getSubject());

        Student s = new Student();
        s.setId(markParameter.getStudentId());
        result.setStudent(s);

        Teacher t = new Teacher();
        t.setId(markParameter.getTeacherId());
        result.setTeacher(t);
        return result;
    }
}
