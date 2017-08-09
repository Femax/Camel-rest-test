package fedosov.agilityhackertest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "leave_request")
public class LeaveRequest {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column
    @ElementCollection(targetClass = Integer.class,fetch = FetchType.EAGER)
    private Set<Integer> createdOn;
    private String createdBy;
    @Column
    @ElementCollection(targetClass = Integer.class,fetch = FetchType.EAGER)
    private Set<Integer> modifiedOn;
    private String modifiedBy;
    @Column
    @ElementCollection(targetClass = Integer.class,fetch = FetchType.EAGER)
    private Set<Integer> submittedOn;
    private String submittedBy;
    @Column
    @ElementCollection(targetClass = String.class,fetch = FetchType.EAGER)
    private List<String> attachments;
    private String notes;
    private String status;

    @OneToMany(mappedBy = "leaveRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DayOfAbsence> dayOfAbsences;

    @OneToMany(mappedBy = "leaveRequest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Approval> approvals;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Set<Integer> getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Set<Integer> submittedOn) {
        this.submittedOn = submittedOn;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<DayOfAbsence> getDayOfAbsences() {
        return dayOfAbsences;
    }

    public void setDayOfAbsences(Set<DayOfAbsence> dayOfAbsences) {
        this.dayOfAbsences = dayOfAbsences;
    }

    public Set<Approval> getApprovals() {
        return approvals;
    }

    public void setApprovals(Set<Approval> approvals) {
        this.approvals = approvals;
    }
}