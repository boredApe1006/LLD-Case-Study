package withoutcor.apis;

import withoutcor.handler.*;
import withoutcor.managers.TokenManager;
import withoutcor.managers.UserManager;

import java.util.List;

public class PlayVideoAPI {

//    private final List<RequestHandler> requestHandlers;
//
//    public PlayVideoAPI(List<RequestHandler> requestHandlers) {
//        this.requestHandlers = requestHandlers;
//    }

    public Response playVideo(Request request) {
       RequestHandlerFactory.getHandler("playVideo").handle(request);


    }

//    private void handle(Request request) {
//        // VALIDATION
//        // AUTHENTICATION
//        // AUTHORIZATION
//
//        for (RequestHandler requestHandler : requestHandlers) {
//            requestHandler.handle(request);
//        }
//    }
}
