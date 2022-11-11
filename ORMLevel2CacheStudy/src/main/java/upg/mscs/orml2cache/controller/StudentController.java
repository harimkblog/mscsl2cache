package upg.mscs.orml2cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upg.mscs.orml2cache.entity.Student;
import upg.mscs.orml2cache.service.StudentService;

@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/student")
    public Student save(@RequestBody Student e) {
        return service.saveStudent(e);
    }

    @GetMapping("/student")
    public Student getById(@RequestParam Integer i) {
        return service.getById(i);
    }

}
