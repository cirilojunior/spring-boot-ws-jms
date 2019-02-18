package com.mycompany;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@ComponentScan(basePackages = "com.mycompany.*")
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean(name = "holiday")
    public DefaultWsdl11Definition mpWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("HumanResource");
        wsdl11Definition.setLocationUri("/holidayService/");
        wsdl11Definition.setTargetNamespace("http://mycompany.com/hr/definitions");
        wsdl11Definition.setCreateSoap11Binding(true);
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/services/*");
    }

    @Bean
    public XsdSchema hrSchema() {
        return new SimpleXsdSchema(new ClassPathResource("/wsdl/tutorial_spring/hr.xsd"));
    }

}
