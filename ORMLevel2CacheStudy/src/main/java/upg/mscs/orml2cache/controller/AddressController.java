package upg.mscs.orml2cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import upg.mscs.orml2cache.entity.Student;
import upg.mscs.orml2cache.service.AddressService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AddressController {

    @Autowired
    AddressService as;

    @GetMapping("/address/load10K")
    public Map<String, Object> load10KAddress() {
        long time1 = System.currentTimeMillis();
        int s =  as.load10K();
        long time2 = System.currentTimeMillis();
        Map<String, Object> m = new HashMap<>();
        m.put("timeTaken", (Long) time2-time1);
        m.put("size", s);
        return m;
    }
}
