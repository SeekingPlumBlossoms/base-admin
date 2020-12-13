package cn.huanzi.qch.baseadmin.sys.sysuser.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yebin
 * @version 1.0
 * @className LiOrder
 **/
@Data
public class LiOrderVo extends PageCondition implements Serializable {

    public LiOrderVo(){

    }

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 下游订单号
     */
    private String downOrderId;

    /**
     * 充值账户
     */
    private String account;

    /**
     * 订单状态 0成功 1失败 2处理中
     */
    private Integer orderStatus;

    /**
     * 狮灵内部产品id
     */
    private String productId;

    /**
     * 狮灵内部产品名称
     */
    private String productName;

    /**
     * 购买总面值
     */
    private Integer buyValue;

    /**
     * 购买总金额
     */
    private Integer buyPrice;

    /**
     * 订单时间
     */
    private Date orderTime;

    /**
     * 订单完成时间
     */
    private Date orderEndTime;

    /**
     * 下游商户id
     */
    private String downId;
    /**
     * 下游商户名稱
     */
    private String downName;

    @org.springframework.data.annotation.Transient
    private Date queryOrderStartTime;

    @Transient
    private Date queryOrderEndTime;


}
