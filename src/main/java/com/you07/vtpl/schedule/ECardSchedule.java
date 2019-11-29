package com.you07.vtpl.schedule;
import com.you07.vtpl.service.LocationEcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @author egan
 * @date 2019/11/29 10:44
 * @desc
 */
@Component
@EnableScheduling
public class ECardSchedule implements SchedulingConfigurer {

    @Autowired
    private LocationEcardService locationEcardService;

    private static String cron;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                locationEcardService.saveEcardRecord();
                System.out.println("TaskCronChange task is running ... " + new Date());
            }
        };
        Trigger trigger = new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                //任务触发，可修改任务的执行周期.
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        };
        taskRegistrar.addTriggerTask(task, trigger);
    }

    @Value("${ecard.cron}")
    public void setCron(String cron){
        ECardSchedule.cron = cron;
    }
}
