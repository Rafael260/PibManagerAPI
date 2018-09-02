package org.pibreidosreis.stub;

import org.pibreidosreis.dto.MemberDTO;

import java.time.LocalDate;

public class MemberDTOStub {

    public static MemberDTO createMemberDTO(){
        MemberDTO member = new MemberDTO();
        member.setAddress(AddressDTOStub.createAddressDTO());
        member.setDateOfBirth(LocalDate.of(1995,10,18));
        member.setName("Name test");
        member.setPhone("11999999999");
        return member;
    }
}
