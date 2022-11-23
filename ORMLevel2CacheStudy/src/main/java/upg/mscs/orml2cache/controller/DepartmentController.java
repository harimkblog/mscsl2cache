package upg.mscs.orml2cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import upg.mscs.orml2cache.entity.Department;
import upg.mscs.orml2cache.service.DepartmentService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService ds;

    @GetMapping("/department/load")
    public Map<String, Object> loadMany(@RequestParam int from, @RequestParam int to, @RequestParam boolean cacheQuery ) {
        long time1 = System.currentTimeMillis();
        int s =  ds.loadMany(from, to, cacheQuery);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", time2-time1);
        m.put("size", s);
        return m;
    }

    @GetMapping("/department")
    public Map<String, Object> loadId(int id) {
        long time1 = System.currentTimeMillis();
        Department d = ds.loadId(id);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", time2-time1);
        m.put("department", d);
        return m;
    }

    @PostMapping("/department/update")
    public Map<String, Object> updateDepartment(int id) {
        long time1 = System.currentTimeMillis();
        int ret = ds.updateDepartment(id);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", time2-time1);
        m.put("ret", ret);
        return m;
    }

}
