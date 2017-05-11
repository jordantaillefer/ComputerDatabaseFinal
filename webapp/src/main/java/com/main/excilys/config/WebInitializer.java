package com.main.excilys.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@ComponentScan(basePackages = { "com.main.excilys" })
@EnableTransactionManagement
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] { SpringRootConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { SpringWebConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}