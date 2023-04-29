package inmemoryMySQL.constraint;

import inmemoryMySQL.data.Database;
import inmemoryMySQL.data.Table;
import inmemoryMySQL.sqlcommand.SQLCommand;

public class RemoveForeignKeyConstraintCommand implements SQLCommand {

    private final String parentTable;
    private final String childTable;

    public RemoveForeignKeyConstraintCommand(String parentTable, String childTable) {
        this.parentTable = parentTable;
        this.childTable = childTable;
    }

    @Override
    public void execute() {
         Database db = Database.getInstance();
        Table parent = db.getTable(parentTable);
        Table child = db.getTable(childTable);
        parent.removeConstraint(ConstraintType.CHILD_FOREIGN_KEY , child);
        child.removeConstraint(ConstraintType.PARENT_FOREIGN_KEY, parent);
        System.out.println("foreign key constraint removed");
    }
}
