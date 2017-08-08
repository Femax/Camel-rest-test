package fedosov.agilityhackertest.camel;

import fedosov.agilityhackertest.model.Customer;
import fedosov.agilityhackertest.repository.CustomerRepository;
import fedosov.agilityhackertest.service.CustomerService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .contextPath("/camel-rest-jpa").apiContextPath("/api-doc")
                .apiProperty("api.title", "Camel REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .bindingMode(RestBindingMode.json);

        rest("/customer").description("User rest service")
                .consumes("application/json").produces("application/json")
                .get("/{id}").description("Find Customer by id").head().outType(Customer.class)
                .to("bean:customerService?method=findCustomer(${header.id})")
                .put().description("Update customer").type(Customer.class)
                .to("bean:customerService?method=createOrUpdateCustomer")
                .post().description("Create customer").type(Customer.class)
                .to("bean:customerService?method=createOrUpdateCustomer")
                .get("/findAll").description("Find all customers").outTypeList(Customer.class)
                .to("bean:customerService?method=findCustomers");

    }

}