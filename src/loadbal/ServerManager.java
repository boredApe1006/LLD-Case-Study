package loadbal;

import java.util.ArrayList;
import java.util.List;

public class ServerManager {

    // this method should not be in loadbased strategy class vrna it will violate SRP.
    // loadbasedstrategy class ko ni pta server class mei kya kya attributes hai

   /* public List<Server> getActiveServers() {
        List<Server> servers = getServers();
        List<Server> activeServers = new ArrayList<>();
        for (Server server : servers) {
            if(server.isHealthy())
                activeServers.add(server);
        }
    } */
    // filter out servers which are healthy
    // filter out servers which got last request
    // filter out servers which got max requests in last x minutes
    // designing for extension
//    public List<Server> getServers() {
//
//    }

    public List<Server> getFilteredServers(Filter filter) {
        // servers : retrieve all servers from DB
        return filter.filter(servers);

    }
}
