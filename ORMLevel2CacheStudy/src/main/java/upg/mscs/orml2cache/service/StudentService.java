package upg.mscs.orml2cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upg.mscs.orml2cache.entity.Address;
import upg.mscs.orml2cache.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Student saveStudent(Student student) {
        em.merge(student);
        //em.persist(student);
        em.flush();
        return em.find(Student.class, student.getId());
    }

    public int load(Integer limit) {
        TypedQuery<Student> typedQuery =
                em.createQuery("SELECT DISTINCT s FROM Student s  JOIN FETCH s.address JOIN FETCH s.department JOIN FETCH s.courses WHERE s.id < :id", Student.class);
                // em.createQuery("SELECT s FROM Student s JOIN FETCH s.department JOIN FETCH s.address JOINT FETCH s.courses WHERE s.id < :id", Student.class);
        typedQuery.setParameter("id", limit);
        List<Student> l = typedQuery.getResultList();
        return l.size();
    }

    public Student loadId(Integer i) {
        return em.find(Student.class, i);
    }


}
