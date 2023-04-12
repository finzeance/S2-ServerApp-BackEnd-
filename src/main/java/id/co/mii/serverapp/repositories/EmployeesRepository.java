 package id.co.mii.serverapp.repositories;

 import id.co.mii.serverapp.models.Employees;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

 @Repository
 public interface EmployeesRepository extends JpaRepository<Employees, Integer>{}