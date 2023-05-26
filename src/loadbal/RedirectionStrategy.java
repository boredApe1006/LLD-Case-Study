package loadbal;

public interface RedirectionStrategy {

    RedirectionResponse redirect(Request request);
}
