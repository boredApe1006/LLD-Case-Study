package enq.apis;

import enq.handler.EnquiryHandlerFactory;
import enq.handler.Response;

public class HandleEnquiryAPI {

    Response handleEnquiry(String enquiry) {
        EnquiryHandlerFactory.getEnquiryHandler()
                .handle("I want to upgrade for 1 month");
        return null;
    }
}
