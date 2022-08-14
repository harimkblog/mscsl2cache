package upg.mscs.orml2cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import upg.mscs.orml2cache.entity.Employee;
import upg.mscs.orml2cache.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee e) {
        return service.saveEmployee(e);
    }
}
