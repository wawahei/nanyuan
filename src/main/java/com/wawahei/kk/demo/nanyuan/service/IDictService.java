package com.wawahei.kk.demo.nanyuan.service;

import com.wawahei.kk.demo.nanyuan.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author wawahei
 * @since 2021-05-21
 */
public interface IDictService extends IService<Dict> {

    void importData(InputStream inputStream);
}
