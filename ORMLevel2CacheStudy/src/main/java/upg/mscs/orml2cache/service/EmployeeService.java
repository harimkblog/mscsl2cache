package upg.mscs.orml2cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upg.mscs.orml2cache.entity.Student;
import upg.mscs.orml2cache.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;

    public Student saveEmployee(Student emp) {
        return empRepo.save(emp);
    }
}
