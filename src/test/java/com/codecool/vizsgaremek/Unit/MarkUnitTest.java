package com.codecool.vizsgaremek.Unit;

import com.codecool.vizsgaremek.controller.MarkController;
import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.Mark;
import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.service.MarkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MarkController.class)
public class MarkUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MarkService markService;

    @Test
    public void findAll() throws Exception {
        Class classOne = new Class(1L, "1.A");
        Teacher teacherOne = new Teacher(1L, "Nagy Péter", "Matek", "Male");
        Student student = new Student(1L, classOne, "Petike", "Male");
        Mark mark = new Mark(1l, 2.0, "Matek", "June", student, teacherOne);
        Mark markTwo = new Mark(2l, 4.0, "Matek", "June", student, teacherOne);

        when(markService.getMarkList()).thenReturn(new ArrayList<>(List.of(mark, markTwo)));
        mockMvc.perform(get("/mark/get")).andExpect(status().is(404));
        mockMvc.perform(get("/mark/getAll/")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))

                .andExpect(jsonPath("$[0].id", is(mark.getId().intValue())))
                .andExpect(jsonPath("$[0].mark", is(mark.getMark())))
                .andExpect(jsonPath("$[0].month", is(mark.getMonth())))
                .andExpect(jsonPath("$[0].subject", is(mark.getSubject())))
                .andExpect(jsonPath("$[0].student.id", is(mark.getStudent().getId().intValue())))
                .andExpect(jsonPath("$[0].teacher.id", is(mark.getTeacher().getId().intValue())))

                .andExpect(jsonPath("$[1].id", is(markTwo.getId().intValue())))
                .andExpect(jsonPath("$[1].mark", is(markTwo.getMark())))
                .andExpect(jsonPath("$[1].month", is(markTwo.getMonth())))
                .andExpect(jsonPath("$[1].subject", is(markTwo.getSubject())))
                .andExpect(jsonPath("$[1].student.id", is(markTwo.getStudent().getId().intValue())))
                .andExpect(jsonPath("$[1].teacher.id", is(markTwo.getTeacher().getId().intValue())));


    }

    @Test
    public void findByIdAndURLIsOk() throws Exception {
        Class classOne = new Class(1L, "1.A");
        Teacher teacherOne = new Teacher(1L, "Nagy Péter", "Matek", "Male");
        Student student = new Student(1L, classOne, "Petike", "Male");
        Mark mark = new Mark(1L, 2.0, "Matek", "June", student, teacherOne);

        mockMvc.perform(get("/getMarks/" + mark.getId())).andExpect(status().is(404));
        mockMvc.perform(get("/mark/getMark/" + mark.getId())).andExpect(status().isOk());
        when(markService.getMarkById(1L)).thenReturn(mark);
    }

    @Test
    public void AddMarkReturnsSameObject() {
        Class classOne = new Class(1L, "1.A");
        Teacher teacherOne = new Teacher(1L, "Nagy Péter", "Matek", "Male");
        Student student = new Student(1L, classOne, "Petike", "Male");
        Mark mark = new Mark(1l, 2.0, "Matek", "June", student, teacherOne);
        when(markService.add(mark)).thenReturn(mark);
    }

}
