package org.pibreidosreis.controller;

import org.pibreidosreis.dto.MemberDTO;
import org.pibreidosreis.entity.Member;
import org.pibreidosreis.service.MemberService;
import org.pibreidosreis.util.mapper.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/members")
public class MemberController {

    @Autowired
    private MemberService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MemberDTO>> listAll() {
        List<MemberDTO> members = service.findAll(MemberDTO.class);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MemberDTO> findById(@PathVariable Long id) {
        MemberDTO memberDTO = service.findById(id, MemberDTO.class);
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MemberDTO> create(@Valid @RequestBody MemberDTO memberDTO) {
        Member newMember = MapperUtils.map(memberDTO, Member.class);
        newMember = service.insert(newMember);
        return new ResponseEntity<>(MapperUtils.map(newMember, MemberDTO.class),
                HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MemberDTO> update(@PathVariable Long id,
                                            @Valid @RequestBody Member member) {
        member.setId(id);
        member = service.update(member);
        return new ResponseEntity<>(MapperUtils.map(member, MemberDTO.class), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        Member member = service.findById(id);
        service.delete(member);
    }
}
