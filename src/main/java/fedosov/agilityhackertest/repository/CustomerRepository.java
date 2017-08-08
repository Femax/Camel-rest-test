package fedosov.agilityhackertest.repository;

import fedosov.agilityhackertest.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}