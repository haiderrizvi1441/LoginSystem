package com.hr.loginsystemapi.Controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.loginsystemapi.Model.EmployeeRequest;
import com.hr.loginsystemapi.Model.LoginRequest;
import com.hr.loginsystemapi.Model.LoginResponse;
import com.hr.loginsystemapi.Service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    // Injecting Service 
    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/test")
    public String testing(){
        return "Login System Controller is working fine";
    }


    @PostMapping("/saveEmployee")
    public int saveEmployee(@RequestBody EmployeeRequest employeeRequest){
        int id = employeeService.addEmployee(employeeRequest);

        return id;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginEmployee(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = employeeService.loginEmployee(loginRequest);
        return new ResponseEntity<>(loginResponse,HttpStatus.OK);

    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        employeeService.deleteAll();
        return "All Employees Data Deleted";
    }
    

}
