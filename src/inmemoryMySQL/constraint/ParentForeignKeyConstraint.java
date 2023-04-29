package inmemoryMySQL.constraint;

import inmemoryMySQL.data.Row;
import inmemoryMySQL.data.Table;

import java.util.List;

// yeh hm marks(jo ko child hai) table ke lie bna re hai
public class ParentForeignKeyConstraint implements Constraint{

    private final Table parentTable;
    private final List<ColumnMapping> columnMappings;

    public ParentForeignKeyConstraint(Table parentTable, List<ColumnMapping> columnMappings) {
        this.parentTable = parentTable;
        this.columnMappings = columnMappings;
    }

    @Override
    public void applyOnInsertRow(Row rowToBeInserted) {

        for(Row row : parentTable.getRows()){
            boolean allMatch = true;
            for(ColumnMapping columnMapping : columnMappings) {
                if(row.get(columnMapping.getForeignTableCol()) !=
                   rowToBeInserted.get(columnMapping.getCurrentTableCol()))
                    allMatch = false;
            }
            if (allMatch)
                return;
        }
        throw new RuntimeException("Parent Foreign Key Constraint Violated");

    }

    @Override
    public void applyOnUpdateRow(Row rowToBeUpdated) {
              // we have to do similar thing
    }

    @Override
    public void applyOnDeleteRow(Row rowToBeDeleted) {
          // no action marks mei delete krenge toh kuch ni krna pdega
    }
    @Override
    public ConstraintType getConstraintType() {
        return ConstraintType.PARENT_FOREIGN_KEY;
    }

    @Override
    public boolean isRelated(Table relatedTable) {
        return relatedTable.getName().equals(parentTable.getName());
    }

}
