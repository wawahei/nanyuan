package com.wawahei.kk.demo.nanyuan.pojo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 16:25
 **/
@Data
public class ExcelDictDTO {
    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("上级id")
    private Long parentId;

    @ExcelProperty("名称")
    private String name;

    @ExcelProperty("值")
    private Integer value;

    @ExcelProperty("编码")
    private String dictCode;
}