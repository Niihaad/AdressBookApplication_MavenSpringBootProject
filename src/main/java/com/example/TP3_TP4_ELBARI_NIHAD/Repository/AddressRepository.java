package com.example.TP3_TP4_ELBARI_NIHAD.Repository;

import com.example.TP3_TP4_ELBARI_NIHAD.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}