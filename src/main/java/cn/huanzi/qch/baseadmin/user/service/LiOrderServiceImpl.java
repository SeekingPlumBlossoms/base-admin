package cn.huanzi.qch.baseadmin.user.service;

import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import cn.huanzi.qch.baseadmin.common.service.CommonServiceImpl;
import cn.huanzi.qch.baseadmin.sys.sysuser.pojo.SysUser;
import cn.huanzi.qch.baseadmin.sys.sysuser.repository.LiOrderRepository;
import cn.huanzi.qch.baseadmin.sys.sysuser.service.SysUserService;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.LiOrderVo;
import cn.huanzi.qch.baseadmin.sys.sysuser.vo.SysUserVo;
import cn.huanzi.qch.baseadmin.user.model.LiOrder;
import cn.huanzi.qch.baseadmin.util.CopyUtil;
import cn.huanzi.qch.baseadmin.util.SqlUtil;
import org.hibernate.query.internal.NativeQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author yebin
 * @version 1.0
 * @className LiOrderServiceImpl
 * @description TODO
 * @date 2020/8/11 0:28
 **/
@Service
public class LiOrderServiceImpl extends CommonServiceImpl<LiOrderVo, LiOrder, Long> implements LiOrderService {

    @Autowired
    private LiOrderRepository liOrderRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<LiOrder> selectAllData(LiOrder liOrder) {
        List resultList = liOrderRepository.findByOrderId("1");
        return resultList;
    }

    @Override
    public Result<PageInfo<LiOrderVo>> page(LiOrderVo entityVo) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUserVo sysUserVo = sysUserService.findByLoginName(user.getUsername()).getData();

        if(sysUserVo.getUserId().equals("1")){
            entityVo.setDownId("");
        }else {
            entityVo.setDownId(sysUserVo.getUserId());
        }
        //SQL
        LiOrder entity = CopyUtil.copy(entityVo,LiOrder.class);
        StringBuilder sql = SqlUtil.appendFields(entity);
        SqlUtil.appendQueryColumns(entity,sql,"queryOrderStartTime","queryOrderEndTime");

        //设置SQL、映射实体，以及设置值，返回一个Query对象
        Query query = em.createNativeQuery(sql.toString(), LiOrder.class);

        //分页、排序信息，并设置，page从0开始
        PageRequest pageRequest = PageRequest.of(entityVo.getPage() - 1, entityVo.getRows(), new Sort(Sort.Direction.ASC, "id"));
        query.setFirstResult((int) pageRequest.getOffset());
        query.setMaxResults(pageRequest.getPageSize());

        //获取分页结果
        Page page = PageableExecutionUtils.getPage(query.getResultList(), pageRequest, () -> {
            //设置countQuerySQL语句
            Query countQuery = em.createNativeQuery("select count(1) from ( " + ((NativeQueryImpl) query).getQueryString() + " ) count_table");
            //设置countQuerySQL参数
            query.getParameters().forEach(parameter -> countQuery.setParameter(parameter.getName(), query.getParameterValue(parameter.getName())));
            //返回一个总数
            return Long.valueOf(countQuery.getResultList().get(0).toString());
        });

        Result<PageInfo<LiOrderVo>> result = Result.of(PageInfo.of(page, LiOrderVo.class));

        return result;
    }
}
