package hoop.Trade.T001.Service;

import hoop.Mappers.ManagerMapper;
import hoop.Trade.T001.Entity.ManagerEntity;
import hoop.message.ErrorCodeAndMessage;
import hoop.message.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
public class ManagerServiceImp implements ManagerService {

    @Resource
    ManagerMapper managerMapper;

    /**
     * 根据管理员编号查询管理员信息
     *
     * @param managerId
     * @return
     */
    @Override
    public ManagerEntity selectByPrimaryKey(String managerId,String password) {

        ManagerEntity managerEntity = managerMapper.selectByPrimaryKey(managerId);
        log.error("查询回来的实体类:"+managerEntity);
        if (managerEntity == null){
            throw new GlobalException(ErrorCodeAndMessage.ERROR_UNKNOWN);
        }
        /**判断密码是否正确**/
        if (!password.equals(managerEntity.getPassword())){
            throw  new GlobalException(ErrorCodeAndMessage.MANAGER_ERROR);
        }
        return managerEntity;
    }

    /**
     * 根据用户编号查询用户信息
     *
     * @param managerId
     * @return
     */
    @Override
    public ManagerEntity selectByPrimaryKey(String managerId) {
        ManagerEntity managerEntity = managerMapper.selectByPrimaryKey(managerId);
        if (managerEntity == null){
            throw new GlobalException(ErrorCodeAndMessage.ERROR_UNKNOWN);
        }
        return managerEntity;
    }

    /**
     * 添加一条用户信息
     *
     * @param requestMap
     * @return
     */
    @Override
    public int insert(Map<String,Object> requestMap) {
        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setManagerId(((String) requestMap.get("phoneNumber")).substring(0,7));
        managerEntity.setManagerName((String) requestMap.get("managerName"));
        managerEntity.setEmail((String) requestMap.get("email"));
        managerEntity.setPhoneNumber((String) requestMap.get("phoneNumber"));
        managerEntity.setManagerRole(requestMap.get("managerRole"));
        managerEntity.setActive(requestMap.get("active"));
        managerEntity.setPassword((String) requestMap.get("managerPassword"));
        int i = managerMapper.insert(managerEntity);
        if(i !=1){
            throw  new GlobalException(ErrorCodeAndMessage.INSERT_ERROR);
        }
        return i;
    }

    /**
     * 根据用户名|手机号|邮箱进行查询返回多条数据,且按照用户编号排序.支持分页
     *
     * @param map 前端post请求数据map集合
     * @ArrayList<ManagerEntity></>
     **/
    @Override
    public ArrayList<ManagerEntity> selectByNamePhoneEmail(Map<String,Object> map) {
        ManagerEntity managerEntity = new ManagerEntity();

        managerEntity.setManagerName(map.get("managerName").toString().isEmpty()?"MANAGER_NAME":"\""+map.get("managerName").toString()+"\"");
        managerEntity.setPhoneNumber(map.get("phoneNumber").toString().isEmpty()?"PHONE_NUMBER":"\""+map.get("phoneNumber").toString()+"\"");
        managerEntity.setEmail(map.get("email").toString().isEmpty()?"EMAIL":"\""+map.get("email").toString()+"\"");


        return managerMapper.selectByNamePhoneEmail(managerEntity);
    }

    /**
     * 自定义返回结果集,即再次封装mybatis返回的结果集,支持翻页操作
     *
     * @param reqMap
     * @Map<String,Object>
     * @return
     */
    @Override
    public Hashtable<String,ArrayList<TreeMap<String,Object>>>  selectByNamePhoneEmailActive(Map<String, Object> reqMap) {
        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setManagerName(reqMap.get("managerName").toString().isEmpty()?"MANAGER_NAME":"\""+reqMap.get("managerName").toString()+"\"");
        managerEntity.setPhoneNumber(reqMap.get("phoneNumber").toString().isEmpty()?"PHONE_NUMBER":"\""+reqMap.get("phoneNumber").toString()+"\"");
        managerEntity.setEmail(reqMap.get("email").toString().isEmpty()?"EMAIL":"\""+reqMap.get("email").toString()+"\"");
        managerEntity.setPageCount(reqMap.get("pageCount").toString().isEmpty()?0:Integer.parseInt(reqMap.get("pageCount").toString()));

        //每页翻页的条数默认为10条
        managerEntity.setPageSize(2);
     ArrayList<TreeMap<String,Object>>  arrayList = managerMapper.selectByNamePhoneEmailActive(managerEntity);

        Hashtable<String, ArrayList<TreeMap<String, Object>>> hashtable = new Hashtable<>();
            hashtable.put("ManagerInfoList",arrayList);
            return hashtable;
    }
}
