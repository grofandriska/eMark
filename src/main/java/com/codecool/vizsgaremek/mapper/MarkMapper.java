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

    public MarkDto convertMarkToDto(Mark mark){
        MarkDto markDto = new MarkDto();
        markDto.setMarkId(mark.getId());
        markDto.setMonth(mark.getMonth());
        markDto.setStudentId(mark.getStudent().getId());
        markDto.setMark(mark.getMark());
        markDto.setSubject(mark.getSubject());
        markDto.setTeacherId(mark.getTeacher().getId());
        return markDto;
    }

    public Mark convertMarkDtoToEntity(MarkDto mark){
        Mark markResponse = new Mark();
        markResponse.setId(mark.getMarkId());
        markResponse.setMark(mark.getMark());
        markResponse.setMonth(mark.getMonth());

        Student student = new Student();
        student.setId(mark.getStudentId());

        markResponse.setStudent(student);

        Teacher teacher = new Teacher();
        teacher.setId(mark.getTeacherId());

        markResponse.setTeacher(teacher);
        markResponse.setSubject(mark.getSubject());
        return markResponse;
    }
}
