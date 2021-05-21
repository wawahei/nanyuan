package com.wawahei.kk.demo.nanyuan.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.wawahei.kk.demo.nanyuan.config.OssProperties;
import com.wawahei.kk.demo.nanyuan.service.IFileService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 14:47
 **/
@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    private OssProperties ossProperties;

    @Override
    public String upload(InputStream inputStream, String module, String fileName) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(
                ossProperties.getEndpoint(),
                ossProperties.getKeyId(),
                ossProperties.getKeySecret());

        // 判断BUCKET_NAME是否存在
        if(!ossClient.doesBucketExist(ossProperties.getBucketName())){
            ossClient.createBucket(ossProperties.getBucketName());
            ossClient.setBucketAcl(ossProperties.getBucketName(), CannedAccessControlList.PublicRead);
        }

        // 上传文件流。
        // 文件目录结构 "avatar/2021/02/27/uuid.jpg"
        //构建日期路径
        String timeFolder = new DateTime().toString("/yyyy/MM/dd/");
        //文件名生成
        fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
        String key = module + timeFolder + fileName;
        ossClient.putObject(ossProperties.getBucketName(), key, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        //文件的url地址
        //https:// bucketname   .  endpoint / + key
        return "https://" + ossProperties.getBucketName() + "." + ossProperties.getEndpoint() + "/" + key;
    }

    @Override
    public void removeFile(String url) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(
                ossProperties.getEndpoint(),
                ossProperties.getKeyId(),
                ossProperties.getKeySecret());

        // https://srb-file-200921.oss-cn-beijing.aliyuncs.com/
        // test/2021/02/27/f1673221-efb4-4356-98f4-9f0595caa927.jpg
        String host = "https://" + ossProperties.getBucketName() + "." + ossProperties.getEndpoint() + "/";
        String objectName = url.substring(host.length());

        // 删除文件。如需删除文件夹，请将ObjectName设置为对应的文件夹名称。如果文件夹非空，则需要将文件夹下的所有object删除后才能删除该文件夹。
        ossClient.deleteObject(ossProperties.getBucketName(), objectName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}