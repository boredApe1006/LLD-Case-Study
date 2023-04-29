package command.data;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<String> tags = new ArrayList<>() {
        {
           add("knapsack");
           add("math");
           add("sieve");
        }
    };

    public static List<String> getTags() {
        return tags;
    }

    public static void delete(String tag) {
        System.out.println("Tag deleted is " + tag);
        tags.remove(tag);
    }

    public static void insert(String tag) {
        System.out.println("Tag inserted is " + tag);
        tags.add(tag);
    }
}
