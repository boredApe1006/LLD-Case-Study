package command.apis;

import command.cmd.Command;
import command.cmd.CommandFactory;
import command.data.MatchType;
import command.rcv.PartialMatchDeleter;
import command.rcv.PerfectMatchDeleter;
import command.tag.TagManager;

import java.util.regex.Pattern;

public class DeleteTagsAPI {

   public void  deleteTags(String name, MatchType matchType) {
       Command command = null;
       if(matchType.equals(MatchType.PERFECT)) {
             command = CommandFactory.getPerfectMatchDeleteCmd(
                     name,
                     new PerfectMatchDeleter()
             );
       } else if(matchType.equals(MatchType.PARTIAL)) {
           command  = CommandFactory.getPartialMatchDeleteCmd(
                   Pattern.compile(name),
                   new PartialMatchDeleter()
           );
       } else {
           throw new IllegalArgumentException("Invalid MatchType");
       }
       new TagManager(command).changeTags();
   }
}
