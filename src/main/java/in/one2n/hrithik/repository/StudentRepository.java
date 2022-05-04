package in.one2n.hrithik.repository;

import in.one2n.hrithik.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByOrderByNameAsc();

    Optional<Student> findStudentByEmail(String email);
}
