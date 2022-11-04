package upg.mscs.orml2cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import upg.mscs.orml2cache.entity.Student;
import upg.mscs.orml2cache.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping("/employee")
    public Student save(@RequestBody Student e) {
        return service.saveEmployee(e);
    }
}
