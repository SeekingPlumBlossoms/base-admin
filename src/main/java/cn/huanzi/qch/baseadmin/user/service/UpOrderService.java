package cn.huanzi.qch.baseadmin.user.service;

import cn.huanzi.qch.baseadmin.common.service.CommonService;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.LiOrderVo;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.UpOrderVo;
import cn.huanzi.qch.baseadmin.user.model.LiOrder;
import cn.huanzi.qch.baseadmin.user.model.UpOrder;

import java.util.List;

public interface UpOrderService extends CommonService<UpOrderVo, UpOrder, Long> {

    List<UpOrder> selectAllData(UpOrder upOrder);
}
