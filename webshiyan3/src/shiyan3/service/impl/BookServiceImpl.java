package shiyan3.service.impl;

import shiyan3.dao.BookDao;
import shiyan3.dao.impl.BookDaoImpl;
import shiyan3.pojo.Book;
import shiyan3.service.BookSerice;

import java.util.List;

public class BookServiceImpl implements BookSerice {
    BookDao bookDao=new BookDaoImpl();
    @Override
    public int addbook(Book book) {
      if (bookDao.addbook(book)!=0){
          return 1;
      }else return 0;
    }

    @Override
    public List<Book> getbook(int bpage, int bpagenum) {

     return    bookDao.getbook((bpage-1)*bpagenum,bpagenum);
    }

    @Override
    public int bcount() {
        return bookDao.bcount();
    }

    @Override
    public Book getbookbyid(int id) {
        return bookDao.getbookbyid(id);
    }


}
