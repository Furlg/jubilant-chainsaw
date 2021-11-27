package hoop.Trade.T001.Service;

import hoop.Trade.T001.Entity.ManagerEntity;

import java.util.Map;

public interface ManagerService {

    /**
     * 根据管理员编号和密码校验登录
     * @param managerId
     * @return
     */
    ManagerEntity selectByPrimaryKey(String managerId,String password);

    /**
     * 根据用户编号查询用户信息
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
}
