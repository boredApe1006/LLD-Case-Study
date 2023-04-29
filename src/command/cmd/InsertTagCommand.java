package command.cmd;

import command.rcv.PerfectMatchDeleter;

public class InsertTagCommand implements Command{

    private final String name;

    // implement krenge hm
    private final TagInserter tagInserter;
    private final PerfectMatchDeleter perfectMatchDeleter;

    public InsertTagCommand(String name, TagInserter tagInserter,
                            PerfectMatchDeleter perfectMatchDeleter) {
        this.name = name;
        this.tagInserter = tagInserter;
        this.perfectMatchDeleter = perfectMatchDeleter;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {
       this.perfectMatchDeleter.delete(name);
    }
}
