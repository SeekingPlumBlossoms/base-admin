package cn.huanzi.qch.baseadmin.user.service;

import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.sys.sysuser.pojo.SysUser;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.LiOrderVo;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.SysUserVo;
import cn.huanzi.qch.baseadmin.user.model.LiOrder;

import java.util.List;

public interface LiOrderService extends CommonService<LiOrderVo, LiOrder, Long> {

    List<LiOrder> selectAllData(LiOrder liOrder);
}
