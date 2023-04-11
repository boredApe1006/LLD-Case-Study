package LibrMngmntSystem.Searcher;

import LibrMngmntSystem.Book.BookCopy;

import java.util.List;

public class AuthorBasedBookSearcher implements BookSearcher{

    private final List<String> authors;

    public AuthorBasedBookSearcher(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public List<BookCopy> search() {
        return null;
    }
}
