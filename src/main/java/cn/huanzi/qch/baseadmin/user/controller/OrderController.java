package cn.huanzi.qch.baseadmin.user.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.sys.syssetting.service.SysSettingService;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.LiOrderVo;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.SysUserVo;
import cn.huanzi.qch.baseadmin.user.model.LiOrder;
import cn.huanzi.qch.baseadmin.user.service.LiOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yebin
 * @version 1.0
 * @className OrderController
 * @description TODO
 * @date 2020/8/10 23:38
 **/
@RestController
@RequestMapping("/user/order/")
public class OrderController extends CommonController<LiOrderVo, LiOrder, Long> {

    @Autowired
    private LiOrderService liOrderService;

    @Autowired
    private SysSettingService sysSettingService;


    @GetMapping("lOrder")
    public ModelAndView user(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView =  new ModelAndView("order/order","systemName",sysSettingService.get("1").getData().getSysName());
        modelAndView.addObject("userName",user.getUsername());
        return modelAndView;
    }

    @GetMapping("pageOnLine")
    public Result<List<LiOrder>> pageOnLine(LiOrder liOrder){
        ArrayList<SysUserVo> sysUserVoList = new ArrayList<>();
        List<LiOrder> allPrincipals = liOrderService.selectAllData(liOrder);
        return Result.of(allPrincipals);
    }
}
