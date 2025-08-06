package com.school.portal.iamservice.common.domain.config;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskDecorator;
import org.springframework.core.task.support.ContextPropagatingTaskDecorator;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;

@EnableAsync
public class AsyncConfig {

  @Bean(name = "threadPoolTaskExecutor")
  ThreadPoolTaskExecutor threadPoolTaskExecutor(TaskDecorator taskDecorator) {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(10);
    executor.setMaxPoolSize(100);
    executor.setQueueCapacity(50);
    executor.setThreadNamePrefix("async-");
    executor.setTaskDecorator(taskDecorator);
    return executor;
  }

  @Bean
  DelegatingSecurityContextAsyncTaskExecutor taskExecutor(
      @Qualifier("threadPoolTaskExecutor") ThreadPoolTaskExecutor delegate) {
    return new DelegatingSecurityContextAsyncTaskExecutor(delegate);
  }

  @Bean
  TaskDecorator taskDecorator() {
    return new ContextPropagatingTaskDecorator() {
      @Override
      public Runnable decorate(Runnable runnable) {
        return super.decorate(
            () -> {
              try {
                runnable.run();
              } finally {
                MDC.clear();
              }
            });
      }
    };
  }
}
