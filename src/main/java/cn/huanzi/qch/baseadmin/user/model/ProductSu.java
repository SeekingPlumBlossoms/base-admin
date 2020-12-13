package cn.huanzi.qch.baseadmin.user.model;

import cn.huanzi.qch.baseadmin.annotation.Like;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

/**
 * @author yebin
 * @version 1.0
 * @className LiOrder
 **/
@Entity
@Table(name="product_su")
public class ProductSu {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 狮灵内部产品id
     */
    private String prodcutId;

    /**
     * 狮灵内部产品名称
     */
    @Like
    private String prodcutName;

    /**
     * 上游供货商产品id
     */
    private String upProdcutId;

    /**
     * 上游供货商产品名称
     */
    @Like
    private String upProdcutName;

    /**
     * 产品面值
     */
    private Integer productValue;

    public ProductSu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdcutId() {
        return prodcutId;
    }

    public void setProdcutId(String prodcutId) {
        this.prodcutId = prodcutId;
    }

    public String getProdcutName() {
        return prodcutName;
    }

    public void setProdcutName(String prodcutName) {
        this.prodcutName = prodcutName;
    }

    public String getUpProdcutId() {
        return upProdcutId;
    }

    public void setUpProdcutId(String upProdcutId) {
        this.upProdcutId = upProdcutId;
    }

    public String getUpProdcutName() {
        return upProdcutName;
    }

    public void setUpProdcutName(String upProdcutName) {
        this.upProdcutName = upProdcutName;
    }

    public Integer getProductValue() {
        return productValue;
    }

    public void setProductValue(Integer productValue) {
        this.productValue = productValue;
    }
}
