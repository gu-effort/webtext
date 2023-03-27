package shiyan3.pojo;

import java.util.Date;

//订单详情
public class Order {
    private Integer id;
    private String orderId;
    private Integer customerId;
    private String money;
    private String products;
    private String name;
    private String address;
    private String tel;
    private int statusCode=0;
    private String createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", customerId=" + customerId +
                ", money=" + money +
                ", products='" + products + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", statusCode=" + statusCode +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Order(Integer id, String orderId, Integer customerId, String money, String products, String name, String address, String tel, int statusCode, String createTime, Date updateTime) {
        this.id = id;
        this.orderId = orderId;
        this.customerId = customerId;
        this.money = money;
        this.products = products;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.statusCode = statusCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
