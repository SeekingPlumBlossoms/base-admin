package cn.huanzi.qch.baseadmin.sys.sysuser.vo;

import cn.huanzi.qch.baseadmin.common.pojo.PageCondition;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yebin
 * @version 1.0
 * @className LiOrder
 **/
@Data
public class UpOrderVo extends PageCondition implements Serializable {

    public UpOrderVo(){

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
     * 上游供货商订单号
     */
    private String upOrderId;

    /**
     * 狮灵提交到上游的订单号
     */
    private String crOrderId;

    /**
     * 充值账户
     */
    private String account;

    /**
     * 订单状态 0成功 1失败 2处理中
     */
    private Integer orderStatus;

    /**
     * 产品面值
     */
    private Integer productValue;

    /**
     * 产品成本价
     */
    private Integer price;

    /**
     * 购买数量
     */
    private Integer buyNum;

    /**
     * 购买总面值
     */
    private Integer buyValue;

    /**
     * 购买总金额
     */
    private Integer buyCost;

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
    private String upId;

    /**
     * 下游商户id
     */
    private String upProductId;

    /**
     * 订单类型 0 直冲 1卡密
     */
    private Integer orderType;

    /**
     * 充值类型 0自营 1寄售
     */
    private Integer chargeType;

    @Transient
    private Date queryOrderStartTime;

    @Transient
    private Date queryOrderEndTime;
    /**
     * 供应商名称
     */
    private String upName;


}
