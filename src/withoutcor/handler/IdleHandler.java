package withoutcor.handler;

public class IdleHandler implements RequestHandler{
    @Override
    public void handle(Request request) {
        System.out.println("All done");
    }
}
