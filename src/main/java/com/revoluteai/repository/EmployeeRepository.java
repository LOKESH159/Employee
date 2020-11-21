package com.revoluteai.repository;

import com.revoluteai.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {

    @Query("SELECT e FROM Employee e WHERE e.place =:place")
    public List<Employee> findByPlace(@Param("place") String place);

    @Query("SELECT e FROM Employee e WHERE e.place =:place")
    public Page<Employee> fetchEmployeesByPlace(@Param("place") String place, Pageable pageable);

    @Query("SELECT MIN(salary), MAX(salary) FROM Employee e WHERE e.compentencies =:competency")
    public List<Double> fetchEmployeesByCompetency(@Param("competency") String competency);
}
