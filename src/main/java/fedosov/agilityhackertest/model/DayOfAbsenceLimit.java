package fedosov.agilityhackertest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "day_of_avsence_limit")
public class DayOfAbsenceLimit {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Integer maximumCount;
    private String typeOfAbsence;
    @Column(name = "holiday_agreement_id", insertable = false, updatable = false)
    private String holidayAgreementId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "holiday_agreement_id")
    private HolidayAgreement holidayAgreement;

    public Integer getMaximumCount() {
        return maximumCount;
    }

    public void setMaximumCount(Integer maximumCount) {
        this.maximumCount = maximumCount;
    }

    public String getTypeOfAbsence() {
        return typeOfAbsence;
    }

    public void setTypeOfAbsence(String typeOfAbsence) {
        this.typeOfAbsence = typeOfAbsence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHolidayAgreementId() {
        return holidayAgreementId;
    }

    public void setHolidayAgreementId(String holidayAgreementId) {
        this.holidayAgreementId = holidayAgreementId;
    }

    public HolidayAgreement getHolidayAgreement() {
        return holidayAgreement;
    }

    public void setHolidayAgreement(HolidayAgreement holidayAgreement) {
        this.holidayAgreement = holidayAgreement;
    }
}
