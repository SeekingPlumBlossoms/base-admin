package cn.huanzi.qch.baseadmin.user.controller;

import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.sys.syssetting.service.SysSettingService;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.ProductSuVo;
import cn.huanzi.qch.baseadmin.user.model.ProductSu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yebin
 * @version 1.0
 * @className OrderController
 * @description TODO
 * @date 2020/8/10 23:38
 **/
@RestController
@RequestMapping("/user/product/")
public class ProDuctSuController extends CommonController<ProductSuVo, ProductSu, Long> {

    @Autowired
    private SysSettingService sysSettingService;


    @GetMapping("productSu")
    public ModelAndView user(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView =  new ModelAndView("order/productSu","systemName",sysSettingService.get("1").getData().getSysName());
        modelAndView.addObject("userName",user.getUsername());
        return modelAndView;
    }
}
