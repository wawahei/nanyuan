package com.wawahei.kk.demo.nanyuan;

import com.wawahei.kk.demo.nanyuan.sftp.SFTPServerHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import javax.annotation.Resource;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner, ApplicationListener<ContextClosedEvent> {

	@Resource
	private SFTPServerHolder sftpServerHolder;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//启动SFTP服务
		log.info("sftp server starting ");
		sftpServerHolder.sftpServer().start();
		log.info("sftp server started ");
	}

	@Override
	public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
		log.info("sftp server stopping ");
		try{
			sftpServerHolder.sftpServer().stop(true);
			log.info("sftp server stopped");
		}catch (Exception e){
			log.info("sftp server stopping exception:"+e);
		}
	}
}
