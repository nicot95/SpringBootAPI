package com.nicot.SpringBootAPI.config;


import com.nicot.SpringBootAPI.service.TaskService;
import com.nicot.SpringBootAPI.service.TaskServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TaskService getTaskService() {
        return new TaskServiceImpl();
    }
}
