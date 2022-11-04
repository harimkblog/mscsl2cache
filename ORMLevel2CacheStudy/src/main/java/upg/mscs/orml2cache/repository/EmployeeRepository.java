package upg.mscs.orml2cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upg.mscs.orml2cache.entity.Student;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Student, Integer> {
     List<Student> findByName(String name);
}
