package upg.mscs.orml2cache.service;

import org.springframework.stereotype.Service;
import upg.mscs.orml2cache.entity.Department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public int loadMany(Integer from, Integer to, boolean cacheQuery) {
        TypedQuery<Department> typedQuery
                = em.createQuery("SELECT d FROM Department a WHERE a.id between :from and :to", Department.class);
        typedQuery.setParameter("from", from);
        typedQuery.setParameter("to", to);
        typedQuery.setHint("org.hibernate.cacheable", cacheQuery);
        List<Department> l = typedQuery.getResultList();
        return l.size();
    }

    @Transactional
    public Department loadId(Integer id) {
        return em.find(Department.class, id );
    }

}
