package org.pibreidosreis.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pibreidosreis.dto.MemberDTO;
import org.pibreidosreis.entity.Member;
import org.pibreidosreis.stub.MemberDTOStub;
import org.pibreidosreis.util.mapper.MapperUtils;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class MapperUtilsTest {

    @Test
    public void testMemberMap(){
        MemberDTO memberDTO = MemberDTOStub.createMemberDTO();
        Member member = MapperUtils.map(memberDTO,Member.class);
        assertEquals(member.getAddress().getStreet(),memberDTO.getAddress().getStreet());
    }
}
