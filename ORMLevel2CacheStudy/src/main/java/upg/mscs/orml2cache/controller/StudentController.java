package upg.mscs.orml2cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upg.mscs.orml2cache.entity.Student;
import upg.mscs.orml2cache.service.StudentService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    //com.hazelcast.hibernate.HazelcastCacheRegionFactory org.hibernate.cache.ehcache.EhCacheRegionFactory
    @Autowired
    StudentService service;

    @PostMapping("/student")
    public Student save(@RequestBody Student e) {
        return service.saveStudent(e);
    }

    @GetMapping("/student")
    public Map<String, Object> loadId(@RequestParam Integer id) {
        long time1 = System.currentTimeMillis();
        Student s =  service.loadId(id);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", time2-time1);
        m.put("student", s);
        return m;
    }

    @GetMapping("/student/load")
    public Map<String, Object> loadMany(@RequestParam int from, @RequestParam int to, @RequestParam boolean cacheQuery ) {
        long time1 = System.currentTimeMillis();
        int s =  service.loadMany(from, to, cacheQuery);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", time2-time1);
        m.put("size", s);
        return m;
    }

    @PostMapping("/student/update")
    public Map<String, Object> updateStudent(int id) {
        long time1 = System.currentTimeMillis();
        int ret = service.updateStudent(id);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", time2-time1);
        m.put("ret", ret);
        return m;
    }

}
