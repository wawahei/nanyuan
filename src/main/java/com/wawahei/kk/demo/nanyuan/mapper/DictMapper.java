package com.wawahei.kk.demo.nanyuan.mapper;

import com.wawahei.kk.demo.nanyuan.pojo.dto.ExcelDictDTO;
import com.wawahei.kk.demo.nanyuan.pojo.entity.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author wawahei
 * @since 2021-05-21
 */
public interface DictMapper extends BaseMapper<Dict> {

    void insertBatch(List<ExcelDictDTO> list);
}
