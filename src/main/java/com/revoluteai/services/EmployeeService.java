package com.revoluteai.services;


import com.revoluteai.constants.QueryConstants;
import com.revoluteai.entity.Employee;
import com.revoluteai.exceptions.InvalidSalaryPercentage;
import com.revoluteai.repository.EmployeeRepository;
import com.revoluteai.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> updateEmployeeSalaryPercentage(String place, Double percentage){
        StringUtils.isNotNullOrEmpty(place,"Place can't be empty string");
        if(percentage >= 55)
            throw new InvalidSalaryPercentage("Salary percentage can't be greater than 55%");

        List<Employee> employees =  employeeRepository.findByPlace(place);
        if(employees.isEmpty())
            return new ArrayList<>();

        return updateEmployeesSalary(employees,percentage);

    }

    public List<Employee> fetchEmployeeByPlace(String place,int pageNo){
        StringUtils.isNotNullOrEmpty(place,"Place can't be empty string");
        Pageable paging = PageRequest.of(pageNo, QueryConstants.PAGE_LIMIT);
        Page<Employee> employeePage =  employeeRepository.fetchEmployeesByPlace(place,paging);
        List<Employee> employees = employeePage.getContent();
        System.out.println(employees.size());
        return employeePage.getContent();
    }

    public Map<String,Double> fetchEmployeeByCompetency(String competency){
        StringUtils.isNotNullOrEmpty(competency,"Competency can't be empty string");
        List<Double> salaryRange =  employeeRepository.fetchEmployeesByCompetency(competency);
        Collections.sort(salaryRange);
        Map<String,Double> responseMap = new HashMap<>(2);
        responseMap.put("minimum", salaryRange.get(0));
        if(responseMap.size() == 1) {
            responseMap.put("maximum", salaryRange.get(0));
        }
        else
            responseMap.put("maximum", salaryRange.get(1));

        return responseMap;
    }

    private List<Employee> updateEmployeesSalary(List<Employee> employees,double percentage){
        employees.stream().forEach(employee -> updateEmployeeSalary(employee,percentage));
        return employeeRepository.saveAll(employees);
    }

    private void updateEmployeeSalary(Employee employee,double percentage){
        double salary = employee.getSalary();
        double increasedSalary = salary + (salary * percentage/100);
        employee.setSalary(increasedSalary);
    }


}
