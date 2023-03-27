package shiyan3.pojo;

import java.util.List;

//订单收货
public class cart {
    private Integer id;
    private int customerId;
    private int productId;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    private int number=1;

    @Override
    public String toString() {
        return "cart{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", book=" + book +
                ", number=" + number +
                '}';
    }

    public cart(Integer id, int customerId, int productId, int number) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.number = number;
    }

    public cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
