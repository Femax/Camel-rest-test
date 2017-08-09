package fedosov.agilityhackertest.camel;

import fedosov.agilityhackertest.model.HolidayAgreement;
import fedosov.agilityhackertest.model.LeaveRequest;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .contextPath("/camel-rest-jpa")
                .apiProperty("api.title", "Camel REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .bindingMode(RestBindingMode.json);

        rest("/leave-requests").description("Leave Request")
                .consumes("application/json").produces("application/json")
                .get("/{id}").description("Successfully retrieved leave request with id").outType(LeaveRequest.class)
                .to("bean:leaveRequestService?method=findLeaveRequestById(${header.id})")
                .put().description("Update Leave Request with ID").type(LeaveRequest.class)
                .to("bean:leaveRequestService?method=createOrUpdateRequest")
                .post().description("Create customer").type(LeaveRequest.class)
                .to("bean:leaveRequestService?method=createOrUpdateRequest")
                .get("/").description("Find all customers").outTypeList(LeaveRequest.class)
                .to("bean:leaveRequestService?method=findLeaveRequests");


        rest("/holiday-agreements").description("Holiday Agreements")
                .consumes("application/json").produces("application/json")
                .get("/{id}").description("Successfully retrieved leave request with id").outType(HolidayAgreement.class)
                .to("bean:holidayAgreementService?method=findHolidayAgreementById(${header.id})")
                .put().description("Update Leave Request with ID").type(HolidayAgreement.class)
                .to("bean:holidayAgreementService?method=createOrUpdateHolidayAgreement")
                .post().description("Create customer").type(HolidayAgreement.class)
                .to("bean:holidayAgreementService?method=createOrUpdateHolidayAgreement")
                .get("/").description("Retrieve list of Holiday Agreements").outTypeList(HolidayAgreement.class)
                .to("bean:holidayAgreementService?method=findHolidayAgreements");

    }

}