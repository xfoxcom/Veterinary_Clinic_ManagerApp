package Repositories;

import Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteByLastname(String lastname);
    Optional<Employee> findByLastname(String lastname);
}
