package loadbal;

public class LoadBasedStrategy implements RedirectionStrategy{
    @Override
    public RedirectionResponse redirect(Request request) {
        // need to know about the state of the servers
        // logic to retreive state of the servers
        return null;
    }
}
