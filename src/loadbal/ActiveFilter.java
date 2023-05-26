package loadbal;

import java.util.ArrayList;
import java.util.List;

public class ActiveFilter implements Filter{
    @Override
    public List<Server> filter(List<Server> servers) {

        List<Server> activeServers = new ArrayList<>();
        for (Server server : servers) {
            if(server.isHealthy())
                activeServers.add(server);
        }
        return activeServers;
    }
}
