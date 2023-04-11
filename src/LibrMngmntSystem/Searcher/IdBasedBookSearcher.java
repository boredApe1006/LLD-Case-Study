package LibrMngmntSystem.Searcher;

import LibrMngmntSystem.Book.BookCopy;

import java.util.List;

public class IdBasedBookSearcher implements BookSearcher{
    private final int id;

    public IdBasedBookSearcher(int id) {
        this.id = id;
    }

    @Override
    public List<BookCopy> search() {
        return null;
    }
}
