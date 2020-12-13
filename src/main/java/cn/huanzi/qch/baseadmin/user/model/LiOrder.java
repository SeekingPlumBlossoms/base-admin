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
@Table(name = "li_order")
public class LiOrder {
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
    @Between(min = "queryOrderStartTime",max = "queryOrderEndTime")
    private Date orderTime;

    @Transient
    private Date queryOrderStartTime;

    @Transient
    private Date queryOrderEndTime;
    /**
     * 订单完成时间
     */
    private Date orderEndTime;

    /**
     * 下游商户id
     */

    private String downId;

    @Like
    private String downName;

    public String getDownName() {
        return downName;
    }

    public void setDownName(String downName) {
        this.downName = downName;
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

    public String getDownOrderId() {
        return downOrderId;
    }

    public void setDownOrderId(String downOrderId) {
        this.downOrderId = downOrderId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(Integer buyValue) {
        this.buyValue = buyValue;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Transient
    public Date getQueryOrderStartTime() {
        return queryOrderStartTime;
    }
    @Transient
    public void setQueryOrderStartTime(Date queryOrderStartTime) {
        this.queryOrderStartTime = queryOrderStartTime;
    }
    @Transient
    public Date getQueryOrderEndTime() {
        return queryOrderEndTime;
    }
    @Transient
    public void setQueryOrderEndTime(Date queryOrderEndTime) {
        this.queryOrderEndTime = queryOrderEndTime;
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public String getDownId() {
        return downId;
    }

    public void setDownId(String downId) {
        this.downId = downId;
    }
}
