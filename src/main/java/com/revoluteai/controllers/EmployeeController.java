package com.revoluteai.controllers;

import com.revoluteai.entity.Employee;
import com.revoluteai.helpers.ApiResponse;
import com.revoluteai.services.IEmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/revoluteai/employee/")
@ApiOperation(value ="Employees EndPoints")
public class EmployeeController {

    private static  final Logger log = Logger.getLogger(EmployeeController.class.getName());

    @Autowired
    private IEmployeeService employeeService;


   @ApiOperation(value ="Update salary percentage by Place",response = ApiResponse.class)
   @PutMapping("/place/{place}/salary/{percentage}")
    public ApiResponse<List<Employee>> updateEmployee(@ApiParam(value="Place of the Employees",required =  true) @PathVariable(value="place",required = true) String place, @PathVariable(value="percentage") Double percentage){
        log.info("place :: "+place+":: percneta ::"+percentage);
       ApiResponse<List<Employee>> apiResponse = new ApiResponse<>();
       apiResponse.setCode(200);
       apiResponse.setData( employeeService.updateEmployeeSalaryPercentage(place,percentage));
       return apiResponse;
    }

    @GetMapping("/place/{place}")
    @ApiOperation(value ="FetchEmployees By Place",response = ApiResponse.class)
    public ApiResponse<List<Employee>> fetchEmployeesByPlace( @ApiParam(value="Place of the Employees",required =  true) @PathVariable(value="place") String place,@RequestParam(value= "page",defaultValue = "0") int page ){
        log.info("place :: "+place);
        ApiResponse<List<Employee>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(200);
        apiResponse.setData( employeeService.fetchEmployeeByPlace(place,page));
        return apiResponse;
    }

    @GetMapping("/competency/{competency}")
    @ApiOperation(value ="FetchEmployees By Competency with salary Range",response = ApiResponse.class)
    public ApiResponse<Object> fetchEmployeesByPlace(@ApiParam(value="Competency of the Employees",required =  true)@PathVariable(value="competency") String competency){
        log.info("competency :: "+competency);
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        apiResponse.setCode(200);
        apiResponse.setData( employeeService.fetchEmployeeByCompetency(competency));
        return apiResponse;
    }

}
