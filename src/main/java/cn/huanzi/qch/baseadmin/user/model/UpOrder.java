package cn.huanzi.qch.baseadmin.user.model;

import cn.huanzi.qch.baseadmin.annotation.Between;
import cn.huanzi.qch.baseadmin.annotation.Like;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author yebin
 * @version 1.0
 * @className LiOrder
 **/
@Entity
@Table(name = "up_li_order")
public class UpOrder {
    /**
     * id
     */
    @Id
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
    @Between(min = "queryOrderStartTime",max = "queryOrderEndTime")
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

    @Like
    private String upName;

    public Date getQueryOrderStartTime() {
        return queryOrderStartTime;
    }

    public void setQueryOrderStartTime(Date queryOrderStartTime) {
        this.queryOrderStartTime = queryOrderStartTime;
    }

    public Date getQueryOrderEndTime() {
        return queryOrderEndTime;
    }

    public void setQueryOrderEndTime(Date queryOrderEndTime) {
        this.queryOrderEndTime = queryOrderEndTime;
    }

    public String getUpName() {
        return upName;
    }

    public void setUpName(String upName) {
        this.upName = upName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUpOrderId() {
        return upOrderId;
    }

    public void setUpOrderId(String upOrderId) {
        this.upOrderId = upOrderId;
    }

    public String getCrOrderId() {
        return crOrderId;
    }

    public void setCrOrderId(String crOrderId) {
        this.crOrderId = crOrderId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getProductValue() {
        return productValue;
    }

    public void setProductValue(Integer productValue) {
        this.productValue = productValue;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(Integer buyValue) {
        this.buyValue = buyValue;
    }

    public Integer getBuyCost() {
        return buyCost;
    }

    public void setBuyCost(Integer buyCost) {
        this.buyCost = buyCost;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public String getUpId() {
        return upId;
    }

    public void setUpId(String upId) {
        this.upId = upId;
    }

    public String getUpProductId() {
        return upProductId;
    }

    public void setUpProductId(String upProductId) {
        this.upProductId = upProductId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }
}
