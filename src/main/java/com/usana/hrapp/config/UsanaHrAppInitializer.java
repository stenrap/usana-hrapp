package com.usana.hrapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class UsanaHrAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class, PropertyConfig.class, DatabaseConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
