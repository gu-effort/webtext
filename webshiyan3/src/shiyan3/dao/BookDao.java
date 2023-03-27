package shiyan3.dao;

import shiyan3.pojo.Book;

import java.util.List;

public interface BookDao {
    int addbook(Book book);
    List<Book> getbook(int start,int num);
    int bcount();
    Book getbookbyid(int id);

}
