package hoop.Mappers;

import hoop.Trade.T001.Entity.ManagerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

@Mapper
public interface ManagerMapper {
    int deleteByPrimaryKey(String managerId);

    int insert(ManagerEntity record);

    /**增加管理
     * @param record
     * @return */
    int insertSelective(ManagerEntity record);

    ManagerEntity selectByPrimaryKey(String managerId);

    int updateByPrimaryKeySelective(ManagerEntity record);
    
    /**
     * 根据管理员id进行更新管理员信息,使用的方式为MySQL的procedure存储程序
     * @param record
     * @return 
     */
    int updateByPrimaryKey(ManagerEntity record);

    /**
     * 根据管理员名称|手机号|邮箱查询
     * @param managerEntity
     * @return  ArrayList<ManagerEntity></>
     * **/
    ArrayList<ManagerEntity> selectByNamePhoneEmail(ManagerEntity managerEntity);


    /**
     * 根据管理员名称|手机号|邮箱|是否活动|等差查询且饭返回的是与实体类不关联的HashMap
     * @param managerEntity
     * @return HashMap
     */
    ArrayList<TreeMap<String,Object>> selectByNamePhoneEmailActive(ManagerEntity managerEntity);
}