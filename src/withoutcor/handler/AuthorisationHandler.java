package withoutcor.handler;

import withoutcor.managers.UserManager;

public class AuthorisationHandler implements RequestHandler{

    private final RequestHandler nextHandler;
    private final UserManager userManager;

    public AuthorisationHandler(RequestHandler nextHandler, UserManager userManager) {
        this.nextHandler = nextHandler;
        this.userManager = userManager;
    }

    @Override
    public void handle(Request request) {

        if( !this.userManager.isSubscribed(request.getToken()) ) {
            throw new RuntimeException("Authorisation failed");
        }
        this.nextHandler.handle(request);
    }
}
