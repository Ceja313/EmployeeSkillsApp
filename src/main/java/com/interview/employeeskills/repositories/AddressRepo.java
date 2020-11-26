package com.interview.employeeskills.repositories;

import com.interview.employeeskills.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {

    Address getAddressById(String pId);

}
