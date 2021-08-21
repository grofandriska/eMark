package com.codecool.vizsgaremek.service;

import com.codecool.vizsgaremek.exception.MarkException;
import com.codecool.vizsgaremek.mapper.MarkMapper;
import com.codecool.vizsgaremek.modell.Mark;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.modell.dto.MarkDto;
import com.codecool.vizsgaremek.repository.MarkRepository;
import com.codecool.vizsgaremek.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MarkService {

    MarkRepository markRepository;
    TeacherRepository teacherRepository;
    MarkMapper markMapper;

    public MarkService(MarkRepository markRepository, TeacherRepository teacherRepository, MarkMapper markMapper) {
        this.markRepository = markRepository;
        this.teacherRepository = teacherRepository;
        this.markMapper = markMapper;
    }

    public Mark add(Mark mark) {
        Long id = mark.getTeacher().getId();
        Teacher teacher = teacherRepository.findById(id).get();
        if (teacher.getSubject().equals(mark.getSubject())) {
            markRepository.save(mark);
        } else {
            throw new RuntimeException("Please check your saving data ");
        }
        return mark;
    }

    public Mark getMarkById(Long id) {
       /* Mark responseMark = new Mark();
        try {
            responseMark = markRepository.findById(id).get();
            log.info("Mark found by :" + id);
            return responseMark;

        } catch (MarkException exception) {
            log.info("Something went wrong when looking for Mark by ID :" + id + " see Details" + exception.getMessage());
        }*/
        return markRepository.findById(id).get();
    }

    public List<Mark> getMarkList() {
        List<Mark> marks = markRepository.findAll();
        List<Mark> marksResponse = new ArrayList<>();
        for (Mark mark : marks) {
            marksResponse.add(mark);
        }
        return marksResponse;
    }

    public void deleteMarkByID(Long id) {
        try {
            markRepository.deleteById(id);
        } catch (MarkException e) {
            log.info("Something went wrong when looking for Mark_id :" + id + "! see Details" + e.getMessage());
        }

    }

    public Mark update(Long id, Mark mark) {
        markRepository.findById(id).map(mark1 -> {
            mark1.setMark(mark.getMark());
            mark1.setMonth(mark.getMonth());
            mark1.setStudent(mark.getStudent());
            mark1.setSubject(mark.getSubject());
            mark1.setTeacher(mark.getTeacher());

            return markRepository.save(mark1);
        });
        throw new MarkException(id);

    }

    public double getStudentAverage(Long id) {
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

    public double getStudentAverageBySubject(Long id, String subject) {
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

    public double getStudentAverageBySubjectAndMonth(Long id, String subject, String month) {
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