package inmemoryMySQL.constraint;

import inmemoryMySQL.data.Row;
import inmemoryMySQL.data.Table;


// student table
// marks table => marks table has foreign key student_id
// so student is the parent class and marks is the child class

//Student mei kuch add kra no problem but student mei delete kra toh
//marks se bhi delete krna pdega
//Marks se delete kra toh no problem but marks mei add kra toh check krna pdega student mei hai ya
//ni
//ChildForeignKey constraint is jb student(jo ki parent hai) usme delete krenge toh marks(child) se bhi delete
//kra pdega toh this is ChildForeignKeConstraint

//Mark is a child and it has a parent. The constraint we are referencing to parent is ParenForeignKey
//constraint
public interface Constraint {

    void applyOnInsertRow(Row rowToBeInserted);
    void applyOnUpdateRow(Row rowToBeUpdated);
    void applyOnDeleteRow(Row rowToBeDeleted);
    ConstraintType getConstraintType();
    boolean isRelated(Table relatedTable);
}
