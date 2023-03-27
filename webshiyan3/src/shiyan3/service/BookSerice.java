package shiyan3.service;

import shiyan3.pojo.Book;

import java.util.List;

public interface BookSerice {
    int addbook(Book book);
    List<Book> getbook(int bpage,int bpagenum);
    int bcount();
    Book getbookbyid(int id);
}
