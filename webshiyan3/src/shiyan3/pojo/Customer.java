package shiyan3.pojo;

//购买人
public class Customer {
    private Integer id;
    private String name;
    private String password;
    private boolean isVip;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", isVip=" + isVip +
                '}';
    }

    public Customer(Integer id, String name, String password, boolean isVip) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isVip = isVip;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }
}
