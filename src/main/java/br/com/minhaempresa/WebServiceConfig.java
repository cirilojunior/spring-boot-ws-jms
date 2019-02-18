package br.com.minhaempresa;

import br.com.minhaempresa.processoeletronico.schemas.ObjectFactory;
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
@ComponentScan(basePackages = "br.com.minhaempresa.*")
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean(name = "contrato")
    public DefaultWsdl11Definition mpWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProcessoEletronico");
        wsdl11Definition.setLocationUri("/processoEletronicoService");
        wsdl11Definition.setTargetNamespace("http://minhaempresa.com.br/processoeletronico/definitions");
        wsdl11Definition.setCreateSoap11Binding(true);
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/processoEletronicoService/*");
    }

    @Bean
    public XsdSchema peSchema() {
        return new SimpleXsdSchema(new ClassPathResource("/wsdl/minha_empresa.xsd"));
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }

}