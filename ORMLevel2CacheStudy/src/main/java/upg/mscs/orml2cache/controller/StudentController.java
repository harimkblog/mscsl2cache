package upg.mscs.orml2cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upg.mscs.orml2cache.entity.Student;
import upg.mscs.orml2cache.service.StudentService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/student")
    public Student save(@RequestBody Student e) {
        return service.saveStudent(e);
    }

    @GetMapping("/student")
    public Map<String, Object> getById(@RequestParam Integer i) {
        long time1 = System.currentTimeMillis();
        Student s =  service.getById(i);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", (Long) time2-time1);
        m.put("student", s);
        return m;
    }
}
