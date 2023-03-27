package shiyan4.service;

import shiyan4.model.Msg;

import java.util.List;
import java.util.Map;

public interface MsgService {
    //分页获取所有留言
    List<Msg> findByPage(int page, int pageSize, int reStatus);
    List<Msg> findByPage(String sPage, String sPageSize, int reStatus);
    List<Msg> findByPage(String sPage, int reStatus);
       //根据id获取某一条留言
       Msg get(String sid);
       Msg get(int id);
       //获取留言总数
       int count(int reStatus);
       //添加留言
       boolean add(Msg msg);
        //回复留
       boolean reply(Msg msg);
        //删除留
       boolean del(String sid);



       }