package LibrMngmntSystem.Searcher;

import LibrMngmntSystem.Book.BookCopy;
import LibrMngmntSystem.DataAccessor.DBAccessor;
import LibrMngmntSystem.DataAccessor.Results;
import LibrMngmntSystem.DataAccessor.ResultsConverter;

import java.util.List;

public class NameBasedBookSearcher implements BookSearcher{
    private final String bookName;
    private final DBAccessor dbAccessor;
    public NameBasedBookSearcher(String bookName) {
        this.bookName = bookName;
        this.dbAccessor = new DBAccessor();
    }
    public List<BookCopy> search() {
       Results results = dbAccessor.getBooksWithName(bookName);
       return ResultsConverter.convertToBookCopies(results);
    }

}
