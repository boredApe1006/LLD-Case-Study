package LibrMngmntSystem.lib;

import LibrMngmntSystem.Book.BookCopy;
import LibrMngmntSystem.DataAccessor.DBAccessor;
import LibrMngmntSystem.DataAccessor.Results;
import LibrMngmntSystem.DataAccessor.ResultsConverter;
import LibrMngmntSystem.user.Member;
import java.util.List;


public class Library {

    private final DBAccessor dbAccessor;

    public Library(DBAccessor dbAccessor) {
        this.dbAccessor = dbAccessor;
    }


    public void addBookCopy(BookCopy bookCopy) {
        if(bookCopy == null) {
            //
        }
        dbAccessor.insertBookCopy(bookCopy);
    }

    public void deleteBookCopy(BookCopy bookCopy) {
         // check if bookcopy is available
        // deletion
        if(dbAccessor.isCopyAvailable(bookCopy)) {
            dbAccessor.deleteBookCopy(bookCopy);
        }
    }

  public void blockMember(Member member) {

  }

  public void issueBook(BookCopy bookCopy, Member member) {

  }

  public void submitBook(BookCopy bookCopy, Member member) {

  }

  public Member getBorrower(BookCopy bookCopy) {
        Results results = dbAccessor.getBorrower(bookCopy);
        return ResultsConverter.convertToMember(results);
  }

  public List<BookCopy> getBorrowedBooks(Member member) {

  }

}

