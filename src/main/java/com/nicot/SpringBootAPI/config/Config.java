package com.nicot.SpringBootAPI.config;


import com.nicot.SpringBootAPI.repository.TaskJDBCRepository;
import com.nicot.SpringBootAPI.service.TaskJPAService;
import com.nicot.SpringBootAPI.service.TaskService;
import com.nicot.SpringBootAPI.service.TaskJDBCService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TaskJDBCService getJDBCTaskService() {
        return new TaskJDBCService();
    }

    @Bean
    public TaskJPAService getJPATaskService() {
        return new TaskJPAService();
    }

    @Bean
    public TaskJDBCRepository getTaskJDBCRepository() {
        return new TaskJDBCRepository();
    }
}
