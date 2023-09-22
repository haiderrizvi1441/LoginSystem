package com.hr.loginsystemapi.Service;

import com.hr.loginsystemapi.Model.EmployeeRequest;
import com.hr.loginsystemapi.Model.LoginRequest;
import com.hr.loginsystemapi.Model.LoginResponse;

public interface EmployeeService {

    int addEmployee(EmployeeRequest employeeRequest);

    LoginResponse loginEmployee(LoginRequest loginRequest);

    void deleteAll();
    

}
