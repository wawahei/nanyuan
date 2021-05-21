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
 * 借款人上传资源表
 * </p>
 *
 * @author wawahei
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BorrowerAttach implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 借款人id
     */
    private Long borrowerId;

    /**
     * 图片类型（idCard1：身份证正面，idCard2：身份证反面，house：房产证，car：车）
     */
    private String imageType;

    /**
     * 图片路径
     */
    private String imageUrl;

    /**
     * 图片名称
     */
    private String imageName;

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
