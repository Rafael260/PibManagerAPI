package org.pibreidosreis.stub;

import org.pibreidosreis.dto.AddressDTO;

public class AddressDTOStub {

    public static AddressDTO createAddressDTO(){
        AddressDTO address = new AddressDTO();
        address.setCity("Sao Paulo");
        address.setState("SP");
        address.setNeighborhood("Pirituba");
        address.setStreet("Street test");
        address.setNumber("123");
        address.setPostalCode("00000000");
        return address;
    }
}
