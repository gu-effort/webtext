package qimo.service.impl;

import qimo.dao.ComicDao;
import qimo.dao.impl.ComicDaoImpl;
import qimo.model.Comic;
import qimo.model.Comment;
import qimo.service.ComicService;

import java.util.List;

public class ComicServiceImpl implements ComicService {
    ComicDao comicDao=new ComicDaoImpl();

    @Override
    public int addComic(Comic comic) {
        return comicDao.addComic(comic);
    }

    @Override
    public List<Comic> getComic(int first, int last,int region) {
        return comicDao.getComic((first-1)*last,last,region);
    }

    @Override
    public int count(int region) {
        return comicDao.count(region);
    }

    @Override
    public List<Comic> getIndexComic() {
        return comicDao.getIndexComic();
    }

    @Override
    public int delComic(int id) {
        return comicDao.deleteComic(id);
    }

    @Override
    public Comic getComicById(int id) {
        return comicDao.getComicById(id);
    }

    @Override
    public int updateComic(Comic comic) {
        return comicDao.updateComic(comic);
    }

    @Override
    public List<Comic> searchComic(int first,int last,String value) {
        return comicDao.searchComic((first-1)*last,last,value);
    }

    @Override
    public int searchCount(String comicName) {
        return comicDao.searchCount(comicName);
    }


}
