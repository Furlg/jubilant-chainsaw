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
}
