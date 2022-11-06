package upg.mscs.orml2cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upg.mscs.orml2cache.entity.Student;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class EmployeeService {
    //@Autowired
    //private EmployeeRepository empRepo;
    @Autowired
    private EntityManager em;

    @Transactional
    public Student saveEmployee(Student student) {
        em.merge(student);
        //em.persist(student);
        em.flush();
        return em.find(Student.class, student.getId());
    }
}
