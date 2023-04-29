package command.main;

import command.apis.DeleteTagsAPI;
import command.data.MatchType;

public class TagChangeStimulator {
    public static void main(String[] args) {
        new DeleteTagsAPI().deleteTags("math.*", MatchType.PARTIAL);
    }
}
