package com.wawahei.kk.demo.nanyuan.service;

import java.io.InputStream;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 14:47
 **/
public interface IFileService {
    /**
     * 文件上传至阿里云
     */
    String upload(InputStream inputStream, String module, String fileName);

    void removeFile(String url);
}
