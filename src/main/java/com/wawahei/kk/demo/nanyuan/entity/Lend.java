package com.wawahei.kk.demo.nanyuan.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 标的准备表
 * </p>
 *
 * @author wawahei
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Lend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 借款用户id
     */
    private Long userId;

    /**
     * 借款信息id
     */
    private Long borrowInfoId;

    /**
     * 标的编号
     */
    private String lendNo;

    /**
     * 标题
     */
    private String title;

    /**
     * 标的金额
     */
    private BigDecimal amount;

    /**
     * 投资期数
     */
    private Integer period;

    /**
     * 年化利率
     */
    private BigDecimal lendYearRate;

    /**
     * 平台服务费率
     */
    private BigDecimal serviceRate;

    /**
     * 还款方式
     */
    private Integer returnMethod;

    /**
     * 最低投资金额
     */
    private BigDecimal lowestAmount;

    /**
     * 已投金额
     */
    private BigDecimal investAmount;

    /**
     * 投资人数
     */
    private Integer investNum;

    /**
     * 发布日期
     */
    private LocalDateTime publishDate;

    /**
     * 开始日期
     */
    private LocalDate lendStartDate;

    /**
     * 结束日期
     */
    private LocalDate lendEndDate;

    /**
     * 说明
     */
    private String lendInfo;

    /**
     * 平台预期收益
     */
    private BigDecimal expectAmount;

    /**
     * 实际收益
     */
    private BigDecimal realAmount;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 审核时间
     */
    private LocalDateTime checkTime;

    /**
     * 审核用户id
     */
    private Long checkAdminId;

    /**
     * 放款时间
     */
    private LocalDateTime paymentTime;

    /**
     * 放款人id
     */
    private LocalDateTime paymentAdminId;

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
