package com.hexagonal.demo.application.core.usecase;

import com.hexagonal.demo.application.core.domain.Address;
import com.hexagonal.demo.application.core.domain.Customer;
import com.hexagonal.demo.application.ports.out.FindAddressByZipCodeOutputPort;
import com.hexagonal.demo.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer, String ZipCode){
        var address = findAddressByZipCodeOutputPort.find(ZipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
