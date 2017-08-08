package fedosov.agilityhackertest.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

class Backend extends RouteBuilder {

    @Override
    public void configure() {
        // A first route generates some orders and queue them in DB
        from("timer:new-order?delay=1s&period={{example.generateOrderPeriod:2s}}")
                .routeId("generate-order")
                .bean("customerService", "generateCustomer")
                .to("jpa:org.apache.camel.example.spring.boot.rest.jpa.Customer")
                .log("Inserted new order ${body.id}");
    }
}