package fedosov.agilityhackertest.service;

import fedosov.agilityhackertest.model.HolidayAgreement;
import fedosov.agilityhackertest.model.LeaveRequest;
import fedosov.agilityhackertest.repository.HolidayAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Max on 09.08.2017.
 */
@Component
public class HolidayAgreementService {

    @Autowired
    HolidayAgreementRepository holidayAgreementRepository;


    public Iterable<HolidayAgreement> findHolidayAgreements() {
        return holidayAgreementRepository.findAll();
    }

    public HolidayAgreement findHolidayAgreementById(String id) {
        return holidayAgreementRepository.findOne(id);
    }

    public void createOrUpdateHolidayAgreement(HolidayAgreement holidayAgreement) {
        holidayAgreementRepository.save(holidayAgreement);
    }
}
