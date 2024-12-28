package Week2Springboot.Week2Practice.Repositories;

import Week2Springboot.Week2Practice.Entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Cars,Integer> {
}
