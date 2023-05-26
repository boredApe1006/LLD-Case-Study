package loadbal;

public class RedirectionManager {

    private final RedirectionStrategy strategy;

    public RedirectionManager(RedirectionStrategy strategy) {
        this.strategy = strategy;
    }

    public RedirectionResponse manageRedirection(Request request) {
        this.strategy.redirect(request);
    }
}
