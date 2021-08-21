package com.codecool.vizsgaremek.service;

import com.codecool.vizsgaremek.exception.TeacherException;
import com.codecool.vizsgaremek.mapper.TeacherMapper;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.TeacherDto;
import com.codecool.vizsgaremek.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TeacherService {

    TeacherRepository teacherRepository;

    TeacherMapper teacherMapper;

    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public void saveTeacher(TeacherDto teacher) {
        try {
            teacherRepository.save(teacherMapper.convertTeacherDtoToEntity(teacher));
        } catch (RuntimeException e) {
            log.info("Teacher can not be added" + e.getMessage());
        }
    }

    public void updateTeacherById(Long id, Teacher teacherUpdate) {
        try {
            Teacher teacher = teacherRepository.findById(id).get();
            teacher.setName(teacherUpdate.getName());
            teacher.setSubject(teacherUpdate.getSubject());
            teacher.setGender(teacherUpdate.getGender());
            teacherRepository.save(teacher);
        } catch (TeacherException e) {
            log.info("Something went wrong when updating Teacher by id :" + id);
            log.info("See details :" + e);

            throw new TeacherException(id);

        }
    }

    public void deleteTeacherById(Long id) {
        try {
            teacherRepository.deleteById(id);
        } catch (TeacherException e) {
            log.info("Something went wrong when deleting Teacher by id :" + id);
            log.info("See details :" + e);
            throw new TeacherException(id);
        }
    }

    public List<TeacherDto> getAllTeacher() {
        List<TeacherDto> teacherListResponse = new ArrayList<>();
        try {
            List<Teacher> teacherList = teacherRepository.findAll();
            for (Teacher teacher : teacherList) {
                teacherListResponse.add(teacherMapper.convertTeacherToDto(teacher));
            }
            return teacherListResponse;
        } catch (RuntimeException e) {
            log.info( "Can't access teachers. See details: " + e);
            log.info(e.getMessage());
        }
        return teacherListResponse;
    }
}
