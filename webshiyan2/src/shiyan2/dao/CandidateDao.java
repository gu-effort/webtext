package shiyan2.dao;

import shiyan2.model.Candidate;

import java.util.List;

public interface CandidateDao {
    Candidate findById(int id);
    List<Candidate> findAll();
    int insert(Candidate user);
    int update(Candidate user);

    int sub(Candidate user);
    int delete(int id);


}
