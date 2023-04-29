package command.cmd;

import command.rcv.PartialMatchDeleter;
import command.rcv.PerfectMatchDeleter;

import java.util.regex.Pattern;

public class CommandFactory {

    private CommandFactory() { }

    public static Command getPartialMatchDeleteCmd(Pattern pattern, PartialMatchDeleter partialMatchDeleter) {
        return new PartialMatchdeleteCommand(
                pattern , partialMatchDeleter
        );
    }

    public static Command getPerfectMatchDeleteCmd(String name, PerfectMatchDeleter perfectMatchDeleter) {
        return new PerfectMatchDeleteCommand(
                name , perfectMatchDeleter
        );
    }
}
