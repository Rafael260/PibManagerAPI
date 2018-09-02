package org.pibreidosreis.service;

import org.pibreidosreis.entity.Member;
import org.pibreidosreis.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService extends AbstractService<Member>{

	private AddressesService addressesService;

	@Autowired
	public MembersService(MembersRepository repository, AddressesService addressesService) {
		super(repository);
		this.addressesService = addressesService;
	}

	@Override
	public void onBeforeInsert(Member memberForSave) {
		this.addressesService.insert(memberForSave.getAddress());
	}

	@Override
	public void onBeforeUpdate(Member memberForUpdate) {
		this.addressesService.update(memberForUpdate.getAddress());
	}
}
