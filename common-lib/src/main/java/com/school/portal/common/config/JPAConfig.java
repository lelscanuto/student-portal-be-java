package com.school.portal.common.config;

import com.school.portal.common.utils.DateUtil;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware", dateTimeProviderRef = "dateTimeProvider")
public class JPAConfig {

  @Bean("auditorAware")
  public AuditorAware<String> auditorAware() {
    return new SpringSecurityAuditorAware();
  }

  @Bean("dateTimeProvider")
  public DateTimeProvider dateTimeProvider() {
    return new ZonedDateTimeDateTimeProvider();
  }

  private static class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
      return Optional.empty();
    }
  }

  private static class ZonedDateTimeDateTimeProvider implements DateTimeProvider {
    @Override
    public Optional<TemporalAccessor> getNow() {
      return Optional.of(DateUtil.getUTCZonedDateTime());
    }
  }
}
