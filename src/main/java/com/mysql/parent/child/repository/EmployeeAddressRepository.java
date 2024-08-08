package com.mysql.parent.child.repository;

import com.mysql.parent.child.entity.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAddressRepository  extends JpaRepository<EmployeeAddress, String> {
}
