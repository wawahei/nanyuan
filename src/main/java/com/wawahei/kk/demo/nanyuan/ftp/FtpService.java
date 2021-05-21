package com.wawahei.kk.demo.nanyuan.ftp;

import org.apache.ftpserver.ftplet.DefaultFtplet;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.FtpletContext;
import org.apache.ftpserver.ftplet.FtpletResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: yanghailang
 * @create: 2021-05-21 17:31
 **/
public class FtpService extends DefaultFtplet {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void init(FtpletContext ftpletContext) throws FtpException {
        super.init(ftpletContext);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public FtpletResult onConnect(FtpSession session) throws FtpException, IOException {
        return super.onConnect(session);
    }

    @Override
    public FtpletResult onDisconnect(FtpSession session) throws FtpException, IOException {
        return super.onDisconnect(session);
    }

    @Override
    public FtpletResult beforeCommand(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.beforeCommand(session, request);
    }

    @Override
    public FtpletResult afterCommand(FtpSession session, FtpRequest request, FtpReply reply) throws FtpException, IOException {
        return super.afterCommand(session, request, reply);
    }

    @Override
    public FtpletResult onLogin(FtpSession session, FtpRequest request) throws FtpException, IOException {
        try {
            // final String info = sdf.format(new Date()) + ":用户 " + session.getUser().getName() + " 登录成功";
            /* 向ftpInfoList添加信息 */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onLogin(session, request);
    }

    @Override
    public FtpletResult onDeleteStart(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onDeleteStart(session, request);
    }

    @Override
    public FtpletResult onDeleteEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onDeleteEnd(session, request);
    }

    @Override
    public FtpletResult onUploadStart(FtpSession session, FtpRequest request) throws FtpException, IOException {
        try {
            final String info = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ":文件 " + request.getArgument() + " 开始上传……………… ";
            /* 向ftpInfoList添加信息 */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onUploadStart(session, request);
    }

    @Override
    public FtpletResult onUploadEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        try {
            final String info = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ":文件 " + request.getArgument() + " 上传成功………………";
            /* 向ftpInfoList添加信息 */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onUploadEnd(session, request);
    }

    @Override
    public FtpletResult onDownloadStart(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onDownloadStart(session, request);
    }

    @Override
    public FtpletResult onDownloadEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onDownloadEnd(session, request);
    }

    @Override
    public FtpletResult onRmdirStart(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onRmdirStart(session, request);
    }

    @Override
    public FtpletResult onRmdirEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onRmdirEnd(session, request);
    }

    @Override
    public FtpletResult onMkdirStart(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onMkdirStart(session, request);
    }

    @Override
    public FtpletResult onMkdirEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onMkdirEnd(session, request);
    }

    @Override
    public FtpletResult onAppendStart(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onAppendStart(session, request);
    }

    @Override
    public FtpletResult onAppendEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onAppendEnd(session, request);
    }

    @Override
    public FtpletResult onUploadUniqueStart(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onUploadUniqueStart(session, request);
    }

    @Override
    public FtpletResult onUploadUniqueEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onUploadUniqueEnd(session, request);
    }

    @Override
    public FtpletResult onRenameStart(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onRenameStart(session, request);
    }

    @Override
    public FtpletResult onRenameEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onRenameEnd(session, request);
    }

    @Override
    public FtpletResult onSite(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onSite(session, request);
    }
}