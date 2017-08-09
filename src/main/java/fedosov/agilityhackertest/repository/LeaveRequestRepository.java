package fedosov.agilityhackertest.repository;

import fedosov.agilityhackertest.model.LeaveRequest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Max on 09.08.2017.
 */
public interface LeaveRequestRepository extends CrudRepository<LeaveRequest, String> {
}
