package shiyan3.pojo;
import java.io.Serializable;
import java.math.BigDecimal;

//书籍
public class Book implements Serializable {
    private int id;
    private String name; //商品名称
    private BigDecimal price; //价格
    private int sale; //折扣
    private long stock; //库存
    private long marketDate; //上市时间
    private String imgUrl; //商品图片
    private String info;//商品详情

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sale=" + sale +
                ", stock=" + stock +
                ", marketDate=" + marketDate +
                ", imgUrl='" + imgUrl + '\'' +
                ", info='" + info + '\'' +
                ", saleprice=" + saleprice +
                ", number=" + number +
                '}';
    }

    public BigDecimal getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private BigDecimal saleprice;
    private int number;
    public Book() {
    }

    public Book(int id, String name, BigDecimal price, int sale, long stock, long marketDate, String imgUrl, String info) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sale = sale;
        this.stock = stock;
        this.marketDate = marketDate;
        this.imgUrl = imgUrl;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public long getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(long marketDate) {
        this.marketDate = marketDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
