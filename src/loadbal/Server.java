package loadbal;

public class Server {

    private final int id;
    private final boolean isHealthy;

    public Server(int id, boolean isHealthy) {
        this.id = id;
        this.isHealthy = isHealthy;
    }
}
