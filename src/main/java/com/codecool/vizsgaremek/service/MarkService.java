package com.codecool.vizsgaremek.service;

import com.codecool.vizsgaremek.exception.MarkException;
import com.codecool.vizsgaremek.log.Log;
import com.codecool.vizsgaremek.mapper.MarkMapper;
import com.codecool.vizsgaremek.modell.Mark;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.MarkDto;
import com.codecool.vizsgaremek.repository.MarkRepository;
import com.codecool.vizsgaremek.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkService {

    MarkRepository markRepository;

    TeacherRepository teacherRepository;

    MarkMapper markMapper;

    public MarkService(MarkRepository markRepository, TeacherRepository teacherRepository, MarkMapper markMapper) {
        this.markRepository = markRepository;
        this.teacherRepository = teacherRepository;
        this.markMapper = markMapper;
    }

    public void add(MarkDto mark) {
        Long id = mark.getTeacherId();
        Teacher teacher = teacherRepository.findById(id).get();
        if (teacher.getSubject().equals(mark.getSubject())) {
            markRepository.save(markMapper.convertMarkDtoToEntity(mark));
        } else {
            throw new RuntimeException("Please check your saving data ");
        }
    }

    public MarkDto getMarkById(Long id) {
        MarkDto responseMark = new MarkDto();
        try {
            responseMark = markMapper.convertMarkToDto(markRepository.getById(id));
            Log.log.info("Mark found by :" + id);
            return responseMark;
        } catch (MarkException exception) {
            Log.log.info("Something went wrong when looking for Mark by ID :" + id + " see Details" + exception.getMessage());
        }
        return responseMark;
    }

    public List<MarkDto> getMarkList() {
        List<Mark> marks = markRepository.findAll();
        List<MarkDto> marksResponse = new ArrayList<>();
        for (Mark mark : marks) {
            marksResponse.add(markMapper.convertMarkToDto(mark));
        }
        return marksResponse;
    }

    public void deleteMarkByID(Long id) {
        try {
            markRepository.deleteById(id);
        } catch (MarkException e) {
            Log.log.info("Something went wrong when looking for Mark by ID! see Details" + e.getMessage());
        }

    }

    public void update(Long id, Mark mark) {
        Mark markUpdate = markRepository.findById(id).get();
        markUpdate.setMark(mark.getMark());
        markUpdate.setMonth(mark.getMonth());
        markUpdate.setStudent(mark.getStudent());
        markUpdate.setSubject(mark.getSubject());
        markUpdate.setTeacher(mark.getTeacher());
        markRepository.save(markUpdate);

    }

    public Double getStudentAverage(Long id) {
        List<Double> marks = new ArrayList<>();
        double sum = 0;
        List<Mark> temp = markRepository.findAll();
        for (Mark mark : temp) {
            if (mark.getStudent().getId().equals(id)) {
                marks.add(mark.getMark());
                sum = sum + mark.getMark();
            }
        }
        return sum / marks.size();

    }

    public Double getStudentAverageBySubject(Long id, String subject) {
        List<Double> marks = new ArrayList<>();
        double sum = 0;
        List<Mark> result = markRepository.findAll();
        for (Mark mark : result) {
            if (mark.getStudent().getId().equals(id) && mark.getSubject().equals(subject)) {
                marks.add(mark.getMark());
                sum = sum + mark.getMark();
            }
        }
        return sum / marks.size();
    }

    public Double getStudentAverageBySubjectAndMonth(Long id, String subject, String month) {
        List<Double> marks = new ArrayList<>();
        double sum = 0;
        List<Mark> result = markRepository.findAll();
        for (Mark mark : result) {
            if (mark.getStudent().getId().equals(id) && mark.getSubject().equals(subject) && mark.getMonth().equals(month)) {
                marks.add(mark.getMark());
                sum = sum + mark.getMark();
            }
        }
        return sum / marks.size();
    }

}