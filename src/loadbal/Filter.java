package loadbal;

import java.util.List;

public interface Filter {

    List<Server> filter(List<Server> servers);
}
