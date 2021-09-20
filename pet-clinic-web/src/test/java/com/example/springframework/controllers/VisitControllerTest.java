package com.example.springframework.controllers;

import com.example.springframework.model.Pet;
import com.example.springframework.services.PetService;
import com.example.springframework.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class VisitControllerTest {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";

    @Mock
    VisitService visitService;

    @Mock
    PetService petService;

    @InjectMocks
    VisitController visitController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        given(petService.findById(1L)).willReturn(new Pet());
        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }

    @Test
    void initNewVisitForm() throws Exception{

        mockMvc.perform(get("/owners/*/pets/{petId}/visits/new",1L))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEWS_PETS_CREATE_OR_UPDATE_VISIT_FORM));
    }

    @Test
    void processNewVisitFormSucces() throws Exception{
        mockMvc.perform(post("/owners/*/pets/{petId}/visits/new",1L)
                        .param("date","2021-11-11")
                        .param("description", "New visit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"))
                .andExpect(model().attributeExists("visit"));
    }

    @Test
    void processNewVisitFormHasErrors() throws Exception{
        mockMvc.perform(post("/owners/*/pets/{petId}/visits/new", 1L)
                        .param("date","2021-11-11"))
                .andExpect(model().attributeHasErrors("visit"))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEWS_PETS_CREATE_OR_UPDATE_VISIT_FORM));
    }
}
