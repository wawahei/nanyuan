package com.wawahei.kk.demo.nanyuan.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 借款人
 * </p>
 *
 * @author wawahei
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Borrower implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 性别（1：男 0：女）
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 学历
     */
    private Integer education;

    /**
     * 是否结婚（1：是 0：否）
     */
    private Boolean isMarry;

    /**
     * 行业
     */
    private Integer industry;

    /**
     * 月收入
     */
    private Integer income;

    /**
     * 还款来源
     */
    private Integer returnSource;

    /**
     * 联系人名称
     */
    private String contactsName;

    /**
     * 联系人手机
     */
    private String contactsMobile;

    /**
     * 联系人关系
     */
    private Integer contactsRelation;

    /**
     * 状态（0：未认证，1：认证中， 2：认证通过， -1：认证失败）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除(1:已删除，0:未删除)
     */
    private Boolean isDeleted;


}
