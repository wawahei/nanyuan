package com.wawahei.kk.demo.nanyuan.controller;


import com.wawahei.kk.demo.nanyuan.common.exception.BusinessException;
import com.wawahei.kk.demo.nanyuan.common.result.R;
import com.wawahei.kk.demo.nanyuan.common.result.ResponseEnum;
import com.wawahei.kk.demo.nanyuan.pojo.entity.Dict;
import com.wawahei.kk.demo.nanyuan.service.IDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author wawahei
 * @since 2021-05-21
 */
@RestController
@RequestMapping("/nanyuan/dict")
@Api(value = "测试接口", tags = "字典管理相关接口", produces = "字典管理接口")
public class DictController {

    @Autowired
    private IDictService dictService;

    @ApiOperation("Excel数据的批量导入")
    @PostMapping("/import")
    public R batchImport(
            @ApiParam(value = "Excel数据字典文件", required = true)
            @RequestParam("file") MultipartFile file){

        try {
            InputStream inputStream = file.getInputStream();
            dictService.importData(inputStream);
            return R.ok().message("数据字典数据批量导入成功");

        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR, e);
        }
    }

    @PostMapping("save")
    @ApiOperation(value = "保存用户",notes = "添加用户2")
    @ApiImplicitParam(name = "新增字典数据dict ...", value = "新增字典数据")
    public R save(Dict dict){
        dictService.save(dict);
        return R.ok().message("保存成功");
    }


    @GetMapping("/list")
    @ApiOperation(value = "字典列表",notes = "测试字典列表")
    public R list(Dict dict){
        List<Dict> list= dictService.list(null);
        return R.ok().data("list",list);
    }

    @DeleteMapping("deleteById/{id}")
    @ApiOperation(value = "根据ID删除字典",notes = "删除字典")
    public R delete(
            @ApiParam(value = "字典 id",required = true)
            @PathVariable Long id){
        dictService.removeById(id);
        return R.ok().message("删除成功");
    }

    @GetMapping("findById/{id}")
    @ApiOperation(value = "根据Id获取用户信息",notes = "根据Id获取用户信息2")
    public R getDict(
            @ApiParam(value = "字典 id",required = true)
            @PathVariable Long id){
        Dict dict = dictService.getById(id);
        return R.ok().data("dict",dict);
    }

}
