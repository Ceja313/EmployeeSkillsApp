package com.interview.employeeskills.repositories;

import com.interview.employeeskills.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to hold address queries.
 * @author Jeff Ceja
 */
public interface AddressRepo extends JpaRepository<Address, Integer> {

    Address getAddressById(String pId);

}
