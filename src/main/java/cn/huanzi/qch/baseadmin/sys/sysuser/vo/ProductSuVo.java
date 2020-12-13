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
public class ProductSuVo extends PageCondition implements Serializable {

    public ProductSuVo(){

    }

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 狮灵内部产品id
     */
    private String prodcutId;

    /**
     * 狮灵内部产品名称
     */
    private String prodcutName;

    /**
     * 上游供货商产品id
     */
    private String upProdcutId;

    /**
     * 上游供货商产品名称
     */
    private String upProdcutName;

    /**
     * 产品面值
     */
    private Integer productValue;

}
