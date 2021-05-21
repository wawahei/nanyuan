package com.wawahei.kk.demo.nanyuan.sftp;

import com.wawahei.kk.demo.nanyuan.config.SftpServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.common.file.virtualfs.VirtualFileSystemFactory;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.command.Command;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.scp.ScpCommandFactory;
import org.apache.sshd.server.subsystem.sftp.SftpSubsystemFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 16:50
 **/
@Configuration
@Slf4j
public class SFTPServerHolder {
    @Resource
    private SftpServerProperties sftpServerProperties;


    /**
     * sftp服务器
     *
     * @return
     */
    @Bean
    public SshServer sftpServer() {

        SshServer sshServer = SshServer.setUpDefaultServer();
        sshServer.setPasswordAuthenticator((username, password, serverSession) -> {
            log.info("sftp username :{} password:", username);
            return sftpServerProperties.getUsername().equals(username) && sftpServerProperties.getPassword().equals(password);
        });
        sshServer.setPort(Integer.valueOf(sftpServerProperties.getPort()));
        sshServer.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(new File(System.getProperty("java.io.tmpdir") + File.pathSeparator + "hostkey.ser").toPath()));
        List<NamedFactory<Command>> namedFactoryList = new ArrayList<>();
        SftpSubsystemFactory factory = new SftpSubsystemFactory();
        namedFactoryList.add(factory);
        sshServer.setSubsystemFactories(namedFactoryList);
        sshServer.setFileSystemFactory(new VirtualFileSystemFactory(new File(sftpServerProperties.getHomeDirectory()).toPath()));
        sshServer.setCommandFactory(new ScpCommandFactory());
        sshServer.setIoServiceEventListener(new SftpIoListener());
        factory.addSftpEventListener(new SftpIoListener());
        sshServer.setSubsystemFactories(Collections.<NamedFactory<Command>>singletonList(factory));
        return sshServer;

    }

}