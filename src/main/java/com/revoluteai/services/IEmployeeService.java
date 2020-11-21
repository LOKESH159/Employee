package com.revoluteai.services;

import com.revoluteai.entity.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {

    public List<Employee> updateEmployeeSalaryPercentage(String place, Double percentage);

    public List<Employee> fetchEmployeeByPlace(String place,int pageNo);

    public Map<String,Double> fetchEmployeeByCompetency(String competency);
}
