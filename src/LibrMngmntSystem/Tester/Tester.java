package LibrMngmntSystem.Tester;

import LibrMngmntSystem.Book.BookCopy;
import LibrMngmntSystem.Book.BookDetails;
import LibrMngmntSystem.DataAccessor.DBAccessor;
import LibrMngmntSystem.Searcher.*;
import LibrMngmntSystem.auth.UserAuthenticator;
import LibrMngmntSystem.id.IDGenerator;
import LibrMngmntSystem.lib.Library;
import LibrMngmntSystem.user.Member;


import java.util.Date;
import java.util.List;

public class Tester {

    private final Library library = new Library(new DBAccessor());
    //validate the parameters
    public List<BookCopy> searchBooksByBookName(String bookName) {
        if(bookName == null) {
            throw new IllegalArgumentException("Bookname can't be null");
        }
        BookSearcher bookSearcher = new NameBasedBookSearcher(bookName);
        return bookSearcher.search();
    }

    public List<BookCopy> searchBookByAuthorName(List<String> authorNames) {
        if(authorNames == null || authorNames.size() == 0 ) {
            throw new IllegalArgumentException("Authornames can't be null or empty");
        }
        BookSearcher bookSearcher = new AuthorBasedBookSearcher(authorNames);
        return bookSearcher.search();
    }

    public List<Member> searchMembersByMemberName(String memberName, String adminToken) throws IllegalAccessException {
             //  authentication & authorization
        if(!UserAuthenticator.isAdmin(adminToken)) {
            throw new IllegalAccessException("Operation forbidden");
        }
        MemberSearcher memberSearcher = new NameBasedMemberSearcher(memberName);
        return memberSearcher.search();
    }

    public void addBook(String bookName, Date publicationDate, List<String> authors, String adminToken) throws IllegalAccessException {
        if(!UserAuthenticator.isAdmin(adminToken)) {
            throw new IllegalAccessException("Operation forbidden");
        }
        // validation based logic here
       BookCopy bookcopy = new BookCopy(new BookDetails(bookName, publicationDate,authors) , IDGenerator.geUniqueId());
        library.addBookCopy(bookcopy);
    }
    public void deleteBook(int bookCopyId, String adminToken) {
       if(bookCopyId < 0 || adminToken == null) {
           throw new IllegalArgumentException("bookCopyId/admin can't be empty");
       }
       BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyId);
       List<BookCopy> bookCopies = bookSearcher.search();
       if(bookCopies == null || bookCopies.size() == 0) {
           throw new RuntimeException("No bookCopies retrieved for given bookCopyId");
       }
        library.deleteBookCopy(bookCopies.get(0));
    }

    public void blockMember(int memberId, String adminToken) {
        // parameter validation and authorization
       MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
       List<Member> members = memberSearcher.search();
        library.blockMember(members.get(0));
    }

    public void issueBook(int bookCopyId, int memberId, String adminToken) {
        // paramter validation and authorization
        BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyId);
       List<BookCopy> bookCopies = bookSearcher.search();
        if(bookCopies == null || bookCopies.size() == 0) {
            throw new RuntimeException("No bookCopies retrieved for given bookCopyId");
        }
       MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
        List<Member> member = memberSearcher.search();
        library.issueBook(bookCopies.get(0),member.get(0));
    }

    public void submitBook(int bookCopyId, int memberId, String adminToken) {

    }
    public Member getBorrowerOfBook(int bookCopyId, String adminToken) {

    }
    public List<BookCopy> getBooksBorrowedByMember(int memberId, String AdminToken) {

    }
}
