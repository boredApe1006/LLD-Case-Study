package withoutcor.handler;

public class ValidationHandler implements RequestHandler{

    private final RequestHandler nextHandler;

    public ValidationHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(Request request) {

        if(request.getHeader() == null || request.getHeader().isEmpty()) {
            throw new IllegalArgumentException("empty header");
        }

        System.out.println("Validation Passed");
        this.nextHandler.handle(request);
    }
}
