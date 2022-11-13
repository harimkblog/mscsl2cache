package upg.mscs.orml2cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import upg.mscs.orml2cache.entity.Address;
import upg.mscs.orml2cache.entity.Student;
import upg.mscs.orml2cache.service.AddressService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AddressController {

    @Autowired
    AddressService as;

    @GetMapping("/address/load")
    public Map<String, Object> load(@RequestParam int from, @RequestParam int to, @RequestParam boolean cacheQuery ) {
        long time1 = System.currentTimeMillis();
        int s =  as.load(from, to, cacheQuery);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", (Long) time2-time1);
        m.put("size", s);
        return m;
    }

    @GetMapping("/address")
    public Map<String, Object> loadId(int id) {
        long time1 = System.currentTimeMillis();
        Address a = as.loadId(id);
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", time2-time1);
        m.put("address", a);
        return m;
    }

}
