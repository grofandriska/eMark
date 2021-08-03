package com.codecool.vizsgaremek.service;

import com.codecool.vizsgaremek.exception.MarkException;
import com.codecool.vizsgaremek.log.Log;
import com.codecool.vizsgaremek.mapper.MarkMapper;
import com.codecool.vizsgaremek.modell.Mark;
import com.codecool.vizsgaremek.modell.dto.MarkDto;
import com.codecool.vizsgaremek.repository.MarkRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkService {

    MarkRepository markRepository;

    MarkMapper markMapper;

    public MarkService(MarkRepository markRepository, MarkMapper markMapper) {
        this.markRepository = markRepository;
        this.markMapper = markMapper;
    }

    public void add(Mark mark) {
        markRepository.save(mark);
        Log.log.info("mark added to " + mark.getStudent().getStudentName() +
                " [" + mark.getMark() + "] "
                + mark.getStudent().getStudentClass());
    }

    public MarkDto getMarkById(Long id) {
        MarkDto responseMark;
        try {
            responseMark = markMapper.convertMarkToDto(markRepository.getById(id));
            Log.log.info("Mark found by " + id);
            return responseMark;

        } catch (MarkException exception) {
            Log.log.info("Something went wrong when looking for Mark by ID! see Details" + exception.getMessage());
        }
        return null;
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
}