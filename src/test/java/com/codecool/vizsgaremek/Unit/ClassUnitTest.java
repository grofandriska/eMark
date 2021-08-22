package com.codecool.vizsgaremek.Unit;

import com.codecool.vizsgaremek.controller.ClassController;
import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.service.ClassService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClassController.class)
public class ClassUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClassService service;

    @Test
    public void findAllAndUrlIsOk() throws Exception {

        Class classOne = new Class(1L, "1.A");
        Class classTwo = new Class(2L, "2.A");
        Class classThree = new Class(3L, "3.A");
        when(service.listAllClass()).thenReturn(new ArrayList<>(List.of(classOne, classTwo, classThree)));

        mockMvc.perform(get("/claSS/getAllClasses")).andExpect(status().is(404));
        mockMvc.perform(get("/class/getAllClass")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(classOne.getId().intValue())))
                .andExpect(jsonPath("$[0].name", is(classOne.getName())))
                .andExpect(jsonPath("$[1].id", is(classTwo.getId().intValue())))
                .andExpect(jsonPath("$[1].name", is(classTwo.getName())))
                .andExpect(jsonPath("$[2].id", is(classThree.getId().intValue())))
                .andExpect(jsonPath("$[2].name", is(classThree.getName())));

    }

    @Test
    public void findClassByIdAndUrlIsOk() throws Exception {
        Class classOne = new Class(1L, "3.B");
        mockMvc.perform(get("/class/getClassByID/" + classOne.getId())).andExpect(status().is(404));
        mockMvc.perform(get("/class/getClassById/" + classOne.getId())).andExpect(status().isOk());
        when(service.getClassById(1L)).thenReturn(classOne);
    }

    @Test
    public void findClassByNameAndUrlIsOk() throws Exception {
        Class classOne = new Class(1L, "3.B");
        mockMvc.perform(get("/class/getClassByNam/" + classOne.getName())).andExpect(status().is(404));
        mockMvc.perform(get("/class/getClassByName/" + classOne.getName())).andExpect(status().isOk());
        when(service.getClassByName("3.B")).thenReturn(classOne);
    }

    @Test
    public void AddClassReturnsSameClassAnd400AtURLDueEmptyBody() throws Exception {
        Class classOne = new Class(1L, "3.B");
        when(service.addClass(classOne)).thenReturn(classOne);
        mockMvc.perform(post("/class/add",classOne)).andExpect(status().is(400));
    }
}
