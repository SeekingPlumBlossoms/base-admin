package cn.huanzi.qch.baseadmin.sys.sysuser.repository;

import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import cn.huanzi.qch.baseadmin.user.model.LiOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiOrderRepository extends CommonRepository<LiOrder, Long> {
    List<LiOrder> findByOrderId(String orderId);
}
