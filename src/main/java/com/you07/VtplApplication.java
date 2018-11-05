package com.you07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@tk.mybatis.spring.annotation.MapperScan(
		basePackages = {"com.you07.eas.dao",
				"com.you07.location.ruijie.dao",
				"com.you07.vtpl.dao",
				"com.you07.location.h3cup.dao",
				"com.you07.location.h3cap.dao",
				"com.you07.map.dao"})
@SpringBootApplication
@EnableScheduling
public class VtplApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtplApplication.class, args);
	}
}
