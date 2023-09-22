package com.hr.loginsystemapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.hr.loginsystemapi.Entity.Employee;
import com.hr.loginsystemapi.Model.EmployeeRequest;
import com.hr.loginsystemapi.Model.LoginRequest;
import com.hr.loginsystemapi.Model.LoginResponse;
import com.hr.loginsystemapi.Repository.EmployeeRepository;

@Repository
public class EmployeeServiceImpl implements EmployeeService{

    // Injecting repository
    @Autowired
    private EmployeeRepository employeeRepository;

    // Injecting password encode
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public int addEmployee(EmployeeRequest employeeRequest) {
         
        // Creating Entity from RequestBody Model
        Employee employee = new Employee();
        employee.setId(employeeRequest.getId());
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPassword(this.passwordEncoder.encode(employeeRequest.getPassword()));

        // Saving the Employee 
        employeeRepository.save(employee);
        
        return employee.getId();

        
    }

    @Override
    public LoginResponse loginEmployee(LoginRequest loginRequest) {

        String msg = "";
        Employee employee1 = employeeRepository.findByEmail(loginRequest.getEmail());
        if(employee1 != null){
            String password = loginRequest.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if(isPwdRight){
                Optional<Employee> employee = employeeRepository.findOneByEmailAndPassword(loginRequest.getEmail(),encodedPassword);
                if(employee.isPresent()){
                    return new LoginResponse("Login Success",true);
                }
                else{
                    return new LoginResponse("Login Failed", false);
                }
            }
            else{
                return new LoginResponse("Password does not Match", false);
            }

        }
        else{
            return new LoginResponse("Email does not exist", false);
        }
        
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
    
}
