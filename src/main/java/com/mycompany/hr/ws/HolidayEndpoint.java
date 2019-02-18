package com.mycompany.hr.ws;

import com.mycompany.hr.schemas.HolidayRequest;
import com.mycompany.hr.service.HumanResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class HolidayEndpoint {

    private static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";

    private HumanResourceService humanResourceService;

    @Autowired
    public HolidayEndpoint(HumanResourceService humanResourceService) {
        this.humanResourceService = humanResourceService;

//        Namespace namespace = Namespace.getNamespace("hr", NAMESPACE_URI);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")
    public void handleHolidayRequest(@RequestPayload HolidayRequest holidayRequest) throws Exception {
        System.out.printf("Recebeu a requisição SOAP...");
        System.out.println(holidayRequest);
        //humanResourceService.bookHoliday(startDate, endDate, name);
    }

}