package com.wawahei.kk.demo.nanyuan.sftp;

import lombok.extern.slf4j.Slf4j;
import org.apache.sshd.common.io.IoAcceptor;
import org.apache.sshd.common.io.IoServiceEventListener;
import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.server.subsystem.sftp.SftpEventListener;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 16:48
 **/
@Slf4j
public class SftpIoListener implements IoServiceEventListener, SftpEventListener {
    @Override
    public void connectionAccepted(IoAcceptor acceptor, SocketAddress local, SocketAddress remote) throws IOException {
        log.info("设备连接建立 connect creat:{}", remote);
    }

    @Override
    public void moved(ServerSession session, Path srcPath, Path dstPath, Collection<CopyOption> opts, Throwable thrown) throws IOException {
        log.info("文件重命名 file moved, srcPath: {}, dstPath: {}", srcPath, dstPath);
    }

    @Override
    public void created(ServerSession session, Path path, Map<String, ?> attrs, Throwable thrown) throws IOException {
        log.info("创建文件 file created, path: {}", path);
    }

    @Override
    public void removed(ServerSession session, Path path, Throwable thrown) throws IOException {
        log.info("文件删除完成 file removed, path：{}", path);
    }
}