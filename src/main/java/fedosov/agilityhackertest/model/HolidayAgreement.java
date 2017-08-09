package fedosov.agilityhackertest.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "holiday_agreement")
public class HolidayAgreement {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column
    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    private Set<Integer> createdOn;
    private String createdBy;
    @Column
    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    private Set<Integer> modifiedOn;
    private String modifiedBy;
    @Column
    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    private Set<Integer> agreedOn;
    private String agreedBy;
    private String employeeId;
    @Column
    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    private Set<Integer> validFrom;
    @Column
    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    private Set<Integer> validUntil;
    @OneToMany(mappedBy = "holidayAgreement", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DayOfAbsenceLimit> dayOfAbsenceLimits;


    public Set<Integer> getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Set<Integer> createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Set<Integer> getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Set<Integer> modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Integer> getAgreedOn() {
        return agreedOn;
    }

    public void setAgreedOn(Set<Integer> agreedOn) {
        this.agreedOn = agreedOn;
    }

    public String getAgreedBy() {
        return agreedBy;
    }

    public void setAgreedBy(String agreedBy) {
        this.agreedBy = agreedBy;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Set<Integer> getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Set<Integer> validFrom) {
        this.validFrom = validFrom;
    }

    public Set<Integer> getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Set<Integer> validUntil) {
        this.validUntil = validUntil;
    }

    public Set<DayOfAbsenceLimit> getDayOfAbsenceLimits() {
        return dayOfAbsenceLimits;
    }

    public void setDayOfAbsenceLimits(Set<DayOfAbsenceLimit> dayOfAbsenceLimits) {
        this.dayOfAbsenceLimits = dayOfAbsenceLimits;
    }
}
