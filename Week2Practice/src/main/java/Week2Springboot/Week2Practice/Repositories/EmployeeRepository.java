package Week2Springboot.Week2Practice.Repositories;

import Week2Springboot.Week2Practice.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
}
