package com.you07;

import com.you07.location.joywise.KafkaSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.naming.Context;

@tk.mybatis.spring.annotation.MapperScan(
		basePackages = {"com.you07.eas.dao",
				"com.you07.location.ruijie.dao",
				"com.you07.vtpl.dao",
				"com.you07.location.h3cup.dao",
				"com.you07.location.h3cap.dao",
				"com.you07.map.dao",
		        "com.you07.location.huawei.dao"})
@SpringBootApplication
@EnableScheduling
public class VtplApplication {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(VtplApplication.class, args);
//		KafkaSender sender = context.getBean(KafkaSender.class);
//		for (int i=0; i<3; i++){
//			sender.send();
//			Thread.sleep(1000L);
//		}
	}
}
