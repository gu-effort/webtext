package qimo.model;

import java.util.Arrays;
import java.util.Date;

public class User {
    private int id;
    private String userNae;
    private String password;
    private String avatar;
    private String email;
    private String phone;
    private long createTime;
    private String[] collection;
    private String[] history;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userNae='" + userNae + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", collection=" + Arrays.toString(collection) +
                ", history=" + Arrays.toString(history) +
                '}';
    }

    public User(int id, String userNae, String password, String avatar, String email, String phone, long createTime, String[] collection, String[] history) {
        this.id = id;
        this.userNae = userNae;
        this.password = password;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;
        this.createTime = createTime;
        this.collection = collection;
        this.history = history;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserNae() {
        return userNae;
    }

    public void setUserNae(String userNae) {
        this.userNae = userNae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getCollection() {
        return collection;
    }

    public void setCollection(String[] collection) {
        this.collection = collection;
    }

    public String[] getHistory() {
        return history;
    }

    public void setHistory(String[] history) {
        this.history = history;
    }

    public User() {
    }
}

