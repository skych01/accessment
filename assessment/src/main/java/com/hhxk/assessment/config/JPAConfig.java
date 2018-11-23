package com.hhxk.assessment.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ch
 * 扫描包下的组件 如repository,service等 交给spring管理
 */


@Configuration
@EnableJpaRepositories(basePackages = {"com.hhxk.assessment.repository"})
@EntityScan({"com.hhxk.assessment.entity"})
@ComponentScan({"com.hhxk.assessment"})
public class JPAConfig {
}
