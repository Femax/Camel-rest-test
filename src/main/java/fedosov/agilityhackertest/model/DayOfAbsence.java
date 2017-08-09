package fedosov.agilityhackertest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "day_of_absence")
public class DayOfAbsence {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> date;
    private String type;
    @Column(name = "leave_request_id", insertable = false, updatable = false)
    private String leaveRequestId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leave_request_id")
    private LeaveRequest leaveRequest;

    public List<Integer> getDate() {
        return date;
    }

    public void setDate(List<Integer> date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LeaveRequest getLeaveRequest() {
        return leaveRequest;
    }

    public void setLeaveRequest(LeaveRequest leaveRequest) {
        this.leaveRequest = leaveRequest;
    }

    public String getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(String leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }
}