package upg.mscs.orml2cache.service;

import org.springframework.stereotype.Service;
import upg.mscs.orml2cache.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public int loadMany(Integer from, Integer to, boolean cacheQuery) {
        TypedQuery<Course> typedQuery
                = em.createQuery("SELECT d FROM Course c WHERE c.id between :from and :to", Course.class);
        typedQuery.setParameter("from", from);
        typedQuery.setParameter("to", to);
        typedQuery.setHint("org.hibernate.cacheable", cacheQuery);
        List<Course> l = typedQuery.getResultList();
        return l.size();
    }

    @Transactional
    public Course loadId(Integer id) {
        return em.find(Course.class, id );
    }

}
