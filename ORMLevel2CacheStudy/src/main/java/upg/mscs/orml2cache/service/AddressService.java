package upg.mscs.orml2cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upg.mscs.orml2cache.entity.Address;
import upg.mscs.orml2cache.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private EntityManager em;

    public int load10K() {
        TypedQuery<Address> typedQuery
                = em.createQuery("SELECT a FROM Address a WHERE a.id<10000", Address.class);
        List<Address> l = typedQuery.getResultList();
        return l.size();
    }
}
