package qimo.service.impl;

import qimo.dao.CommentDao;
import qimo.dao.impl.CommentDaoImpl;
import qimo.model.Comment;
import qimo.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao=new CommentDaoImpl();
    @Override
    public int addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public int deleteComment(int id) {
        return commentDao.deleteComment(id);
    }

    @Override
    public List<Comment> getComment(int comicId) {
        return commentDao.getComment(comicId);
    }
}
