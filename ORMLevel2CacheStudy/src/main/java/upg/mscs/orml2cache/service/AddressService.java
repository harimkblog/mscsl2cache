package upg.mscs.orml2cache.service;

import org.springframework.stereotype.Service;
import upg.mscs.orml2cache.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class AddressService {
    @PersistenceContext
    private EntityManager em;

    public int load(Integer limit) {
        TypedQuery<Address> typedQuery
                = em.createQuery("SELECT a FROM Address a WHERE a.id < :id", Address.class);
        typedQuery.setParameter("id", limit);
        List<Address> l = typedQuery.getResultList();
        return l.size();
    }

    public Address loadId(Integer id) {
        return em.find(Address.class, id );
    }

}
