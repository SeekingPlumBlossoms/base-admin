package cn.huanzi.qch.baseadmin.sys.sysuser.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.user.model.LiOrder;
import cn.huanzi.qch.baseadmin.user.model.UpOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpOrderRepository extends CommonRepository<UpOrder, Long> {
    List<UpOrder> findByOrderId(String orderId);
}
