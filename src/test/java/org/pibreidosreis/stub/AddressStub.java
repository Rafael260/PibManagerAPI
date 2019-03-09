package org.pibreidosreis.stub;

import org.pibreidosreis.entity.Address;

public class AddressStub {

    public static Address create() {
        Address address = new Address();
        address.setCity("Sao Paulo");
        address.setState("SP");
        address.setNeighborhood("Pirituba");
        address.setStreet("Street test");
        address.setNumber("123");
        address.setPostalCode("00000000");
        return address;
    }
}
