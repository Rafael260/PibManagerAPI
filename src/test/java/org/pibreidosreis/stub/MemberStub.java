package org.pibreidosreis.stub;

import org.pibreidosreis.entity.Member;

import java.time.LocalDate;

public class MemberStub {

    public static Member create() {
        Member member = new Member();
        member.setName("Fulano");
        member.setDateOfBirth(LocalDate.now());
        member.setPhone("11999999999");
        member.setAddress(AddressStub.create());
        return member;
    }
}
