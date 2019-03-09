package org.pibreidosreis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pibreidosreis.service.MembersService;
import org.pibreidosreis.stub.MemberDTOStub;
import org.pibreidosreis.stub.MemberStub;
import org.pibreidosreis.util.mapper.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MembersController.class)
public class MembersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MembersService service;

    @Test
    public void shouldValidateFieldsOnMemberCreation() throws Exception {
        this.mockMvc.perform(post("/members").contentType(MediaType.APPLICATION_JSON).content("{}"))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldCreateMember() throws Exception{
        when(service.insert(any())).thenReturn(MemberStub.create());
        this.mockMvc.perform(post("/members").contentType(MediaType.APPLICATION_JSON).content(memberAsJson()))
                .andExpect(status().isCreated());
    }

    private String memberAsJson() throws JsonProcessingException {
        return MapperUtils.getMapper().writeValueAsString(MemberDTOStub.createMemberDTO());
    }
}
