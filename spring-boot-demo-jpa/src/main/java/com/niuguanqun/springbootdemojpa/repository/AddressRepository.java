package com.niuguanqun.springbootdemojpa.repository;

import com.niuguanqun.springbootdemojpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}