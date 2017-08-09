package fedosov.agilityhackertest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "approval")
public class Approval {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String approvedBy;
    @Column
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> approvedOn = null;
    private String remarks;
    private String outcome;
    @Column(name = "leave_request_id", insertable = false, updatable = false)
    private String leaveRequestId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leave_request_id")
    private LeaveRequest leaveRequest;

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public List<Integer> getApprovedOn() {
        return approvedOn;
    }

    public void setApprovedOn(List<Integer> approvedOn) {
        this.approvedOn = approvedOn;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(String leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public LeaveRequest getLeaveRequest() {
        return leaveRequest;
    }

    public void setLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequest = leaveRequest;
    }
}