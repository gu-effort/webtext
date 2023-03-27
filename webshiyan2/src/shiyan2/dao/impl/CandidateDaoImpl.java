package shiyan2.dao.impl;

import shiyan2.dao.CandidateDao;
import shiyan2.model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateDaoImpl extends BaseDao implements CandidateDao {

    @Override
    public Candidate findById(int id) {
        Candidate user=null;
        String sql="SELECT *FROM mydb.table_candidate WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs =pstmt.executeQuery();
            while (rs.next()){
                user=new Candidate();
                user.setId(id);
                user.setName(rs.getString("name"));
                user.setPhotoUrl(rs.getString("photoUrl"));
                user.setVotes(Integer.parseInt(rs.getString("votes")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Candidate> findAll() {
        List<Candidate> candidateList=new ArrayList<>();
        String sql="SELECT * FROM table_candidate";
        try {
            stmt =conn.createStatement();
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Candidate user=new Candidate();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPhotoUrl(rs.getString("photoUrl"));
                user.setVotes(rs.getInt("votes"));
                candidateList.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return candidateList;
    }

    @Override
    public int insert(Candidate user) {
        int result=0;
        String sql="insert into mydb.table_candidate(name,photoUrl) VALUES (?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPhotoUrl());
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Candidate user) {

        int result=0;
        String sql="UPDATE mydb.table_candidate SET name=?,photoUrl=?,votes=? WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPhotoUrl());
            pstmt.setInt(3,user.getVotes());
            pstmt.setInt(4,user.getId());
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(int id) {
        int result=0;
        String sql="DELETE FROM mydb.table_candidate  WHERE id=?";
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
    public int sub(Candidate user) {
        int result=0;
        String sql="UPDATE mydb.table_candidate SET votes=? WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,user.getVotes());
            pstmt.setInt(2,user.getId());
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
