package com.wawahei.kk.demo.nanyuan.service.impl;

import com.alibaba.excel.EasyExcel;
import com.wawahei.kk.demo.nanyuan.listener.ExcelDictDTOListener;
import com.wawahei.kk.demo.nanyuan.pojo.dto.ExcelDictDTO;
import com.wawahei.kk.demo.nanyuan.pojo.entity.Dict;
import com.wawahei.kk.demo.nanyuan.mapper.DictMapper;
import com.wawahei.kk.demo.nanyuan.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author wawahei
 * @since 2021-05-21
 */
@Service
@Slf4j
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {


    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void importData(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelDictDTO.class, new ExcelDictDTOListener(baseMapper)).sheet().doRead();
        log.info("Excel导入成功");
    }
}
