package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
