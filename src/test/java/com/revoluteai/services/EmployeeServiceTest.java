package com.revoluteai.services;

import com.revoluteai.exceptions.InvalidSalaryPercentage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeServiceTest {

    private EmployeeService employeeService = new EmployeeService();

    @Test
    void updateEmployeeSalaryPercentageIfPlaceIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> employeeService.updateEmployeeSalaryPercentage(null,40.0));
        assertEquals("Place can't be empty string", exception.getMessage());

    }

    @Test
    void updateEmployeeSalaryPercentageIfPlaceIsEmptyString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> employeeService.updateEmployeeSalaryPercentage(" ",40.0));
        assertEquals("Place can't be empty string", exception.getMessage());

    }

    @Test
    void updateEmployeeSalaryPercentageIfSalaryPercentageIsGreaterThan55() {
        InvalidSalaryPercentage exception = assertThrows(InvalidSalaryPercentage.class, () -> employeeService.updateEmployeeSalaryPercentage("CHENNAI",65.0));
        assertEquals("Salary percentage can't be greater than 55%", exception.getMessage());
    }

    @Test
    void fetchEmployeeByPlaceWithPlaceNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> employeeService.fetchEmployeeByPlace(" ",1));
        assertEquals("Place can't be empty string", exception.getMessage());
    }

    @Test
    void fetchEmployeeByCompetency() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> employeeService.fetchEmployeeByCompetency(" "));
        assertEquals("Competency can't be empty string", exception.getMessage());
    }
}