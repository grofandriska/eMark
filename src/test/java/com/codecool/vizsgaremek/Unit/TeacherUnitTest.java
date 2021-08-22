package com.codecool.vizsgaremek.Unit;

import com.codecool.vizsgaremek.controller.TeacherController;
import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.Teacher;
import com.codecool.vizsgaremek.service.TeacherService;
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

@WebMvcTest(TeacherController.class)
public class TeacherUnitTest {

    @MockBean
    private TeacherService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllAndUrlIsOk() throws Exception {
        Teacher teacherOne = new Teacher(1L, "Nagy Péter", "Matek", "Male");
        Teacher teacherTwo = new Teacher(2L, "Kiss Géza", "Töri", "Male");
        Teacher teacherThree = new Teacher(3L, "Első Károly", "Tesi", "Male");

        when(service.getAllTeacher()).thenReturn(new ArrayList<>(List.of(teacherOne, teacherTwo, teacherThree)));

        mockMvc.perform(get("/teachers/getAll/")).andExpect(status().is(404));
        mockMvc.perform(get("/teacher/getAll")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(teacherOne.getId().intValue())))
                .andExpect(jsonPath("$[0].name", is(teacherOne.getName())))
                .andExpect(jsonPath("$[0].subject", is(teacherOne.getSubject())))
                .andExpect(jsonPath("$[0].gender", is(teacherOne.getGender())))

                .andExpect(jsonPath("$[1].id", is(teacherTwo.getId().intValue())))
                .andExpect(jsonPath("$[1].name", is(teacherTwo.getName())))
                .andExpect(jsonPath("$[1].subject", is(teacherTwo.getSubject())))
                .andExpect(jsonPath("$[1].gender", is(teacherTwo.getGender())))

                .andExpect(jsonPath("$[2].id", is(teacherThree.getId().intValue())))
                .andExpect(jsonPath("$[2].name", is(teacherThree.getName())))
                .andExpect(jsonPath("$[2].subject", is(teacherThree.getSubject())))
                .andExpect(jsonPath("$[2].gender", is(teacherThree.getGender())));
    }

    @Test
    public void findTeacherByIdAndUrlIsOk() throws Exception {
        Teacher teacherOne = new Teacher(1L, "Nagy Péter", "Matek", "Male");
        mockMvc.perform(get("/teacher/get" + teacherOne.getId())).andExpect(status().is(400));
        mockMvc.perform(get("/teacher/" + teacherOne.getId())).andExpect(status().isOk());
        when(service.getTeacherById(1L)).thenReturn(teacherOne);
    }

    @Test
    public void AddClassReturnsSameClass() {
        Teacher teacherOne = new Teacher(1L, "Nagy Péter", "Matek", "Male");
        when(service.saveTeacher(teacherOne)).thenReturn(teacherOne);
    }
}