package org.pibreidosreis.service;

import org.pibreidosreis.entity.Address;
import org.pibreidosreis.repository.AddressesRepository;
import org.springframework.stereotype.Component;

@Component
public class AddressesService extends AbstractService<Address> {

    public AddressesService(AddressesRepository repository) {
        super(repository);
    }
}
