package cn.huanzi.qch.baseadmin.user.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.sys.syssetting.service.SysSettingService;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.LiOrderVo;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.ProductSuVo;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.SysUserVo;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.UpOrderVo;
import cn.huanzi.qch.baseadmin.user.model.LiOrder;
import cn.huanzi.qch.baseadmin.user.model.ProductSu;
import cn.huanzi.qch.baseadmin.user.model.UpOrder;
import cn.huanzi.qch.baseadmin.user.service.LiOrderService;
import cn.huanzi.qch.baseadmin.user.service.UpOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/user/upOrder/")
public class UpOrderController extends CommonController<UpOrderVo, UpOrder, Long> {

    @Autowired
    private SysSettingService sysSettingService;


    @GetMapping("upOrder")
    public ModelAndView user(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView =  new ModelAndView("order/upOrder","systemName",sysSettingService.get("1").getData().getSysName());
        modelAndView.addObject("userName",user.getUsername());
        return modelAndView;
    }
}
