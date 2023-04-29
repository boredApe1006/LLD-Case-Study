package withoutcor.handler;

import withoutcor.managers.TokenManager;

public class AuthenticationHandler implements RequestHandler{

    private final RequestHandler nextHandler;
    private final TokenManager tokenManager;

    public AuthenticationHandler(RequestHandler nextHandler, TokenManager tokenManager) {
        this.nextHandler = nextHandler;
        this.tokenManager = tokenManager;
    }

    @Override
    public void handle(Request request) {

        String email = this.tokenManager.getEmailFromToken(request.getToken());
        if(!isValidEmail()) {
            throw new RuntimeException("Authentication failed");
        }
        this.nextHandler.handle(request);

    }

    private boolean isValidEmail(String email) {
        return true;
    }
}
