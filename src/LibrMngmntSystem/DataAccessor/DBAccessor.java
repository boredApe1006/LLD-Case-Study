package LibrMngmntSystem.DataAccessor;

import LibrMngmntSystem.Book.BookCopy;

import java.lang.reflect.Member;
import java.util.List;

public class DBAccessor {

    public Results getBooksWithName(String bookName) {

    }
    public Results getBooksWithAuthorName(List<String> authors) {

    }

    public Results getMembersWithName(String memberName) {

    }

    public void insertBookCopy(BookCopy bookCopy) {

    }

    public void deleteBookCopy(BookCopy bookCopy) {

    }

    public void markAsBlocked(Member member) {

    }

    public void issueBookCopyToMember(BookCopy bookCopy, Member member) {

    }
    public void submitBookCopyToMember(BookCopy bookCopy, Member member) {

    }

    public boolean isCopyAvailable(BookCopy bookCopy) {

    }

    public Results getBorrower(BookCopy bookCopy) {

    }

    public Results getBorrowedBooks(Member member) {

    }
}
