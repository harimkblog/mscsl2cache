package upg.mscs.orml2cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import upg.mscs.orml2cache.entity.Course;
import upg.mscs.orml2cache.service.CourseService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    CourseService cs;

    @GetMapping("/course/load")
    public Map<String, Object> loadMany(@RequestParam int from, @RequestParam int to, @RequestParam boolean cacheQuery ) {
        long time1 = System.currentTimeMillis();
        int s =  cs.loadMany(from, to, cacheQuery);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", time2-time1);
        m.put("size", s);
        return m;
    }

    @GetMapping("/course")
    public Map<String, Object> loadId(int id) {
        long time1 = System.currentTimeMillis();
        Course c = cs.loadId(id);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", time2-time1);
        m.put("course", c);
        return m;
    }
    @PostMapping("/course/update")
    public Map<String, Object> updateCourse(int id) {
        long time1 = System.currentTimeMillis();
        int ret = cs.updateCourse(id);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", time2-time1);
        m.put("ret", ret);
        return m;
    }

}
