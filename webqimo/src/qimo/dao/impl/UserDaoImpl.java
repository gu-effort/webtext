package qimo.dao.impl;

import qimo.dao.UserDao;
import qimo.model.User;

import java.sql.SQLException;
import java.util.Arrays;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int insert(User user) {
        int rows = 0;
        String sql = "INSERT INTO user_table(userNae,password,avatar,email,phone,createTime) VALUES(?,?,?,?,?,?)";
        System.out.println("DAO 插入用户: " + user);
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserNae());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getAvatar());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPhone());
            pstmt.setLong(6, user.getCreateTime());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DAO 添加用户失败");
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public User login(String name, String password) {
        User user = null;
        String sql = "SELECT * FROM user_table WHERE userNae=? AND password=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserNae(rs.getString("userNae"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setCreateTime(rs.getLong("createTime"));
                String collection = rs.getString("collection");
                if (collection != null) {
                    String[] collections = collection.split("_");
                    user.setCollection(collections);
                }else {
                    user.setCollection(new String[0]);
                }
                String browseRecords = rs.getString("history");
                if (browseRecords != null) {
                    String[] browseRecord = browseRecords.split("_");
                    user.setHistory(browseRecord);
                }else {
                    user.setHistory(new String[0]);
                }
            }
        } catch (SQLException e) {
            System.out.println("DAO 获取登录用户失败：name=" + name + ", password=" + password);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateBrowsingRecords(User user,String comicId) {
        int rows = 0;
        String sql = "UPDATE user_table SET history=? WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            String[] history = user.getHistory();
            boolean contains = Arrays.asList(history).contains(comicId);
            if (!contains&&comicId!=null) {return 0;}
            else {
                String s = Arrays.toString(user.getHistory());
                StringBuffer ss = new StringBuffer(s);
                ss.append("_");
                ss.append(comicId);
                pstmt.setString(1, ss.toString());
                pstmt.setInt(2, user.getId());
            }
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DAO 修改用户失败");
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public User selectByUserId(int id) {
        User user = null;
        String sql = "SELECT * FROM user_table WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserNae(rs.getString("userNae"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setCreateTime(rs.getLong("createTime"));
                String collection = rs.getString("collection");
                if (collection != null) {
                    String[] collections = collection.split("_");
                    user.setCollection(collections);
                }else {
                    user.setCollection(new String[0]);
                }
                String historys = rs.getString("history");
                if (historys != null) {
                    String[] history = historys.split("_");
                    user.setHistory(history);
                }else {
                    user.setHistory(new String[0]);
                }
            }
        } catch (SQLException e) {
            System.out.println("DAO 获取用户失败: id=" + id);
            e.printStackTrace();
        }
        return user;
    }


}
