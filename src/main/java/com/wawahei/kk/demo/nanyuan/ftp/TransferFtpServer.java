package com.wawahei.kk.demo.nanyuan.ftp;

import com.wawahei.kk.demo.nanyuan.config.FtpServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 17:22
 **/
@Slf4j
@Component
public class TransferFtpServer {

    @Autowired
    private FtpServerProperties ftpServerProperties;

    private ListenerFactory listenerFactory;

    private TransferFtpServer() {
    }

    public FtpServer initFTP() throws FtpException {
        FtpServerFactory serverFactory = new FtpServerFactory();
        Map<String, Ftplet> ftpLets = serverFactory.getFtplets();
        ftpLets.put("ftplet1", new FtpService());
        serverFactory.setFtplets(ftpLets);
        listenerFactory = new ListenerFactory();
        listenerFactory.setPort(ftpServerProperties.getPort()); // 修改默认端口
        serverFactory.addListener("default", listenerFactory.createListener());
        File file = new File(ftpServerProperties.getHomeDirectory());
        if (!file.exists()) {
            file.mkdirs();
        }
        BaseUser user = new BaseUser();
        user.setName(ftpServerProperties.getUsername());
        user.setPassword(ftpServerProperties.getPassword());
        user.setHomeDirectory(ftpServerProperties.getHomeDirectory());
        ArrayList<Authority> authorities = new ArrayList<Authority>(); // 加入可写权限
        authorities.add(new WritePermission());
        user.setAuthorities(authorities);
        serverFactory.getUserManager().save(user);
        return serverFactory.createServer();
    }

}