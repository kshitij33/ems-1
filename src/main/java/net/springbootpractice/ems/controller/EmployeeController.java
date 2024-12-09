package net.springbootpractice.ems.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.springbootpractice.ems.dto.EmployeeDto;
import net.springbootpractice.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {

    private EmployeeService employeeService;
    // Build Add Employee Rest API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        log.info("employeeDto: {}",employeeDto.getEmail());
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee Rest API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    // Build Get all Employees Rest API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Build Update Employee Rest API
    @PutMapping("{id}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updateEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updateEmployee);

        return ResponseEntity.ok(employeeDto);
    }
}
