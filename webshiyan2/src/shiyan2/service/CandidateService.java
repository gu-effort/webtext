package shiyan2.service;

import shiyan2.model.Candidate;

import java.util.List;

public interface CandidateService {

    Candidate get(int id);
    Candidate get(String sid);


    List<Candidate> findAll();
   boolean sub(Candidate user);
    boolean add(Candidate user);
    boolean mod(Candidate user);
    boolean del(int id);
}
