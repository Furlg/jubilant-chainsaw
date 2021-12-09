package hoop.Trade.T001.Controller;

import hoop.Trade.T001.Entity.ManagerEntity;
import hoop.Trade.T001.Service.ManagerServiceImp;
import hoop.message.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping(value = "T001")
public class ManagerController {

    @Resource
    ManagerServiceImp managerServiceImp;

    Response response;

    /***登录模块***/
    @RequestMapping(value = "Q01",method = RequestMethod.POST)
    @ResponseBody
    public Response logIn(@RequestBody Map<String,Object> map){
        log.error("前端上送的mao"+map);
        response = new Response(managerServiceImp.selectByPrimaryKey((String) map.get("managerId"), (String) map.get("password")));
        return  response;
    }

    /**根据用户编号查询管理员信息**/
    @RequestMapping(value = "Q02" ,method = RequestMethod.POST)
    @ResponseBody
    public  Response selectByPrimaryKey(@RequestBody Map<String,Object> map){
        response = new Response(managerServiceImp.selectByPrimaryKey((String) map.get("managerId")));
        return  response;
    }


    /**新增管理员**/
    @RequestMapping(value = "I01",method = RequestMethod.POST)
    @ResponseBody
    public Response insertManager(@RequestBody Map<String,Object> requestMap){
        log.error("前端上送数据"+requestMap);
        response = new Response(managerServiceImp.insert(requestMap));
        return response;
    }

    /**根据用户姓名|手机号|邮箱查询管理员信息**/
    @RequestMapping(value = "Q03" ,method = RequestMethod.POST)
    @ResponseBody
    public Response selectByNamePhoneEmai(@RequestBody Map<String,Object> map){
        log.error(String.valueOf(map));
        response = new Response(managerServiceImp.selectByNamePhoneEmail(map));
        return response;
    }

    /**根据管理员名称|手机号|邮箱|是否有效标志查询管理员信
     * @param reqMap
     * @param reqMap息*
     * @return */
    @RequestMapping(value = "Q04",method = RequestMethod.POST)
    @ResponseBody
    public Response selectByNamePhoneEmailActive(@RequestBody Map<String,Object> reqMap){
        response = new Response(managerServiceImp.selectByNamePhoneEmailActive(reqMap));
        return response;
    }
    /**
     * 根据管理员id更新管理员信息
     * @param record
     * @return 
     */
    @RequestMapping(value = "U01",method = RequestMethod.POST)
    @ResponseBody
    public Response updateByPrimaryKey(@RequestBody Map<String,Object> reqMap){
        response = new Response(managerServiceImp.updateByPrimaryKey(reqMap));
        return response;
    }
}
