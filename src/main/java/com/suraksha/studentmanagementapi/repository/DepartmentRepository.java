package com.suraksha.studentmanagementapi.repository;

import com.suraksha.studentmanagementapi.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}