package com.wawahei.kk.demo.nanyuan;

import com.wawahei.kk.demo.nanyuan.config.TaskCronExpressionProperties;
import com.wawahei.kk.demo.nanyuan.ftp.TransferFtpServer;
import com.wawahei.kk.demo.nanyuan.sftp.SFTPServerHolder;
import com.wawahei.kk.demo.nanyuan.task.ScheduledJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner, ApplicationListener<ContextClosedEvent> {

	@Resource
	private SFTPServerHolder sftpServerHolder;

	@Resource
	private TransferFtpServer transferFtpServer;

	@Resource
	private TaskCronExpressionProperties taskCronExpressionProperties;

	@Resource
	private ApplicationContext applicationContext;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		startFtp();

		startSftp();

		startTask();
	}

	private void startFtp() throws Exception {
		//启动FTP服务
		log.info("ftp server starting ");
		transferFtpServer.initFTP().start();
		log.info("ftp server started ");
	}

	private void startSftp() throws Exception {
		//启动SFTP服务
		log.info("sftp server starting ");
		sftpServerHolder.sftpServer().start();
		log.info("sftp server started ");
	}

	private void  startTask() throws Exception{
		//启动定时任务服务
		log.info("ScheduledJob register starting ");
		//获取所有ScheduledJob注解的bean
		Scheduler scheduler = applicationContext.getBean(Scheduler.class);
		Map<String, Object> jobBeanMap = applicationContext.getBeansWithAnnotation(ScheduledJob.class);
		for (Map.Entry<String,Object> entry: jobBeanMap.entrySet()){
			Object bean = entry.getValue();
			ScheduledJob scheduledJob = AnnotationUtils.findAnnotation(bean.getClass(), ScheduledJob.class);
			String jobName = scheduledJob.name();
			if(!ObjectUtils.isEmpty(scheduledJob)){
				JobKey jobKey = new JobKey(jobName, scheduledJob.group());
				JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) ((Job) bean).getClass()).withIdentity(jobKey).build();
				//触发器键
				TriggerKey triggerKey = new TriggerKey(jobName + "Trigger", scheduledJob.group());
				//配置文件中的定时任务表达式
				String cronExpression = taskCronExpressionProperties.getExpression().get(jobName);
				//触发器
				Trigger trigger = TriggerBuilder.newTrigger()
						.withIdentity(triggerKey)
						.forJob(jobDetail)
						.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing())
						.build();

				//调度任务
				scheduler.scheduleJob(jobDetail, trigger);
			}
		}
		log.info("ScheduledJob register done ");

		Thread.currentThread().join();
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
