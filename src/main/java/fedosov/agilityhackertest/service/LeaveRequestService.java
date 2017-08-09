package fedosov.agilityhackertest.service;

import fedosov.agilityhackertest.model.Customer;
import fedosov.agilityhackertest.model.LeaveRequest;
import fedosov.agilityhackertest.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Random;

@Transactional
@Component
public class LeaveRequestService {

    @Autowired
    LeaveRequestRepository leaveRequestRepository;


    public Iterable<LeaveRequest> findLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public LeaveRequest findLeaveRequestById(String id) {
        return leaveRequestRepository.findOne(id);
    }

    public void createOrUpdateRequest(LeaveRequest leaveRequest) {
        leaveRequestRepository.save(leaveRequest);
    }
}
