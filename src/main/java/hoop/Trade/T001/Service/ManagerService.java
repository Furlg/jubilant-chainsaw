package hoop.Trade.T001.Service;

import hoop.Trade.T001.Entity.ManagerEntity;

import java.util.*;

public interface ManagerService {

    /**
     * 根据管理员编号和密码校验登录
     * @param managerId
     * @return
     */
    ManagerEntity selectByPrimaryKey(String managerId,String password);

    /**
     * 根据用户编号查询用户信息,返回单体数据
     * @param managerId
     * @return
     */
    ManagerEntity selectByPrimaryKey(String managerId);

    /**
     * 添加一条用户信息
     * @param record
     * @return
     */
    int insert( Map<String,Object> map);

    /**
     * 根据用户名|手机号|邮箱进行查询返回多条数据,且按照用户编号排序
     * @param map post请求数据封装
     * @ArrayList<ManagerEntity></>
     * **/
    ArrayList<ManagerEntity> selectByNamePhoneEmail(Map<String ,Object> map);

    /**
     * 自定义返回结果集,即再次封装mybatis返回的结果集,支持翻页操作
     * @param reqMap
     * @Map<String,Object>
     */
    Hashtable<String,Object> selectByNamePhoneEmailActive(Map<String,Object> reqMap);
    
    /**
     * 增加管理员
     * @param record
     * @return int 增加成功后返回受影响的条数
     */
    int insertSelective(ManagerEntity record);
    
    /**
     * 根据管理员id进行更新管理员信息,使用的方式为MySQL的procedure存储程序
     * @param record
     * @return 
     */
    int updateByPrimaryKey(Map<String,Object> reqMap);
}
