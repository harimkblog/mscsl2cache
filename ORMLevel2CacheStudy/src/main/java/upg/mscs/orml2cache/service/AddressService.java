package upg.mscs.orml2cache.service;

import org.springframework.stereotype.Service;
import upg.mscs.orml2cache.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public int loadMany(Integer from, Integer to, boolean cacheQuery) {
        TypedQuery<Address> typedQuery
                = em.createQuery("SELECT a FROM Address a WHERE a.id between :from and :to", Address.class);
        typedQuery.setParameter("from", from);
        typedQuery.setParameter("to", to);
        typedQuery.setHint("org.hibernate.cacheable", cacheQuery);
        List<Address> l = typedQuery.getResultList();
        return l.size();
    }

    @Transactional
    public Address loadId(Integer id) {
        return em.find(Address.class, id );
    }

    @Transactional
    public int updateAddress(Integer id) {
        Query query = em.createQuery("UPDATE Address a SET a.city = a.city WHERE a.id = :id");
        query.setParameter("id", id);

        return query.executeUpdate();
    }
}
