package org.pibreidosreis.service;

import org.pibreidosreis.entity.Member;
import org.pibreidosreis.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends AbstractService<Member>{

	@Autowired
	public MemberService(MemberRepository repository) {
		super(repository);
	}
}
