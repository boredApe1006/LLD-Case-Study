package command.rcv;

import command.data.Store;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleter {

    public List<String> delete(String name) {

        List<String> tags = new ArrayList<>();
        Store.getTags().forEach(tag -> tags.add(tag));
        List<String> deletedTags = new ArrayList<>();
        for(String tag : tags) {
            if(name.equals(tag)) {
                Store.delete(tag);
                deletedTags.add(tag);
            }
        }
        return deletedTags;
    }
}
