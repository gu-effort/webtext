package shiyan2.service.impl;

import shiyan2.dao.CandidateDao;
import shiyan2.dao.impl.CandidateDaoImpl;
import shiyan2.model.Candidate;
import shiyan2.service.CandidateService;

import java.util.List;

public class CandidateServiceImpl implements CandidateService {
    CandidateDao candidateDao=new CandidateDaoImpl();

    @Override
    public Candidate get(int id) {
        return candidateDao.findById(id);
    }


    public Candidate get(String sid){
        if (sid==null||"".equals(sid)){
            return null;
        }
        else {
            return get(Integer.parseInt(sid));
        }
    }

    @Override
    public List<Candidate> findAll() {
        return candidateDao.findAll();
    }



    @Override
    public boolean add(Candidate user) {
        return candidateDao.insert(user)==1;
    }

    @Override
    public boolean mod(Candidate user) {
        return candidateDao.update(user)==1;
    }

    @Override
    public boolean sub(Candidate user) {
        return candidateDao.sub(user)==1;
    }
    @Override
    public boolean del(int id) {
        return candidateDao.delete(id)==1;
    }
}
