package upg.mscs.orml2cache.service;

import org.springframework.stereotype.Service;
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

    @Transactional
    public int loadMany(Integer from, Integer to, boolean cacheable) {
        TypedQuery<Student> typedQuery =
                em.createQuery("SELECT DISTINCT s FROM Student s  " +
                        "JOIN FETCH s.address JOIN FETCH s.department JOIN FETCH s.courses WHERE s.id between :from and :to ", Student.class);
        typedQuery.setParameter("from", from);
        typedQuery.setParameter("to", to);
        typedQuery.setHint("org.hibernate.cacheable", cacheable);
        List<Student> l = typedQuery.getResultList();
        return l.size();
    }

    @Transactional
    public Student loadId(Integer i) {
        return em.find(Student.class, i);
    }

}
