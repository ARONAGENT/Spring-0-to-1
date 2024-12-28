package Week2Springboot.Week2Practice.Repositories;

import Week2Springboot.Week2Practice.Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
}
