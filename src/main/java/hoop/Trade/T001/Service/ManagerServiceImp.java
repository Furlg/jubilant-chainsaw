package hoop.Trade.T001.Service;

import hoop.Mappers.ManagerMapper;
import hoop.Trade.T001.Entity.ManagerEntity;
import hoop.message.ErrorCodeAndMessage;
import hoop.message.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;

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
}
