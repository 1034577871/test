package com.ruoyi.leave.config;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfig {
    @Bean
    public RepositoryService repositoryService() {
        System.out.println("初始化RepositoryService");
        RepositoryService repositoryService = ProcessEngines.getDefaultProcessEngine().getRepositoryService();
        System.out.println(repositoryService);
        return repositoryService;
    }

    @Bean
    public TaskService taskService() {
        System.out.println("初始化TaskService");
        TaskService taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();
        System.out.println(taskService);
        return taskService;
    }
    @Bean
    public RuntimeService runtimeService() {
        System.out.println("初始化TaskService");
        RuntimeService runtimeService = ProcessEngines.getDefaultProcessEngine().getRuntimeService();
        System.out.println(runtimeService);
        return runtimeService;
    }
}
