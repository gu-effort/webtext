package qimo.dao.impl;

import qimo.dao.ComicDao;
import qimo.model.Comic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComicDaoImpl extends BaseDao implements ComicDao {
    @Override
    public int addComic(Comic comic) {
        int result;
        String sql="insert into mydb.comic_table(comicName, nickname, cover, region, label, description, remark, year, updateTime, number, popularity,url) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            inster(comic, sql);
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("上传失败");
            throw new RuntimeException(e);
        }
        return result;
    }

    private void inster(Comic comic, String sql) throws SQLException {
        System.out.println("改变没有这里"+comic.getNickname());
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,comic.getComicName());
        pstmt.setString(2,comic.getNickname());
        pstmt.setString(3,comic.getCover());
        pstmt.setString(4,comic.getRegion());
        pstmt.setString(5,comic.getLabel());
        pstmt.setString(6,comic.getDescription());
        pstmt.setString(7,comic.getRemark());
        pstmt.setString(8,comic.getYear());
        pstmt.setString(9,comic.getUpdateTime());
        pstmt.setInt(10,comic.getNumber());
        pstmt.setInt(11,comic.getPopularity());
        pstmt.setString(12,comic.getUrl());
    }

    @Override
    public List<Comic> getComic(int first, int last,int region) {
        List<Comic> comicList= new ArrayList<>();
        String sql;
        if (region==0) {
            sql = "SELECT * FROM mydb.comic_table ORDER BY id LIMIT ?,?";
        }else {
            sql = "SELECT * FROM mydb.comic_table WHERE region=? ORDER BY id LIMIT ?,?";
        }
            try {
                if (region==0){
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, first);
                    pstmt.setInt(2, last);
                    rs = pstmt.executeQuery();
                }else {
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1,region);
                    pstmt.setInt(2, first);
                    pstmt.setInt(3, last);
                    rs = pstmt.executeQuery();
                }
                while (rs.next()) {
                    Comic comic = new Comic();
                    comic.setId(rs.getInt("id"));
                    comic.setComicName(rs.getString("comicName"));
                    comic.setCover(rs.getString("cover"));
                    comicList.add(comic);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return comicList;
    }
    @Override
    public int count(int region) {
        int bcount = 0;
        String sql;
        if (region==0){
            sql = "SELECT count(*) FROM mydb.comic_table";
        }else {
            sql = "SELECT count(region)  FROM mydb.comic_table WHERE region=?";
        }
        try {
            if (region==0){
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
            }else {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,region);
                rs = pstmt.executeQuery();
            }
            while (rs.next()) {
                bcount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bcount;
    }

    @Override
    public List<Comic> getIndexComic() {
        List<Comic> comicList=new ArrayList<>();
        String sql="SELECT * FROM mydb.comic_table order by number desc limit 5";
        try {
            pstmt = conn.prepareStatement(sql);
            getComic(comicList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comicList;
    }

    private void getComic(List<Comic> comicList) throws SQLException {
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Comic comic = new Comic();
            comic.setId(rs.getInt("id"));
            comic.setComicName(rs.getString("comicName"));
            comic.setCover(rs.getString("cover"));
            comicList.add(comic);
        }
    }

    @Override
    public Comic getComicById(int id) {
        Comic comic=new Comic();
        String sql="SELECT * FROM mydb.comic_table WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()){
                comic.setId(id);
                comic.setComicName(rs.getString("comicName"));
                comic.setNickname(rs.getString("nickname"));
                comic.setCover(rs.getString("cover"));
                comic.setRegion(rs.getString("region"));
                comic.setLabel(rs.getString("label"));
                comic.setDescription(rs.getString("description"));
                comic.setRemark(rs.getString("remark"));
                comic.setYear(rs.getString("year"));
                comic.setUpdateTime(rs.getString("updateTime"));
                comic.setNumber(rs.getInt("number"));
                comic.setPopularity(rs.getInt("popularity"));
                comic.setUrl(rs.getString("url"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comic;
    }

    @Override
    public int updateComic(Comic comic) {
       int result=0;
       String sql="UPDATE mydb.comic_table SET comicName=?,nickname=?,cover=?,region=?,label=?,description=?,remark=?,year=?,updateTime=?,number=?,popularity=?,url=? WHERE id=?";
       try {
           inster(comic, sql);
           pstmt.setInt(13,comic.getId());
           result=pstmt.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return result;
    }

    @Override
    public int deleteComic(int id) {
       int result=0;
        String sql="DELETE FROM mydb.comic_table WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Comic> searchComic(int first, int last,String comicName) {
        List<Comic> comicList=new ArrayList<>();
        String sql = "SELECT * FROM mydb.comic_table WHERE comicName LIKE ? ORDER BY id LIMIT ?,?";
        try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"%"+comicName+"%");
                pstmt.setInt(2, first);
                pstmt.setInt(3, last);
            getComic(comicList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comicList;
    }

    @Override
    public int searchCount(String comicName) {
        int searchCount=0;
        String sql="SELECT count(*)  FROM mydb.comic_table WHERE comicName LIKE ? ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+comicName+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                searchCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchCount;
    }



}
