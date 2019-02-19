package br.com.minhaempresa;

import br.com.minhaempresa.processoeletronico.schemas.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

    public static final String WS_LOCATION_URI = "/processoEletronicoService";
    public static final String WS_WSDL_NAME = "contrato";
    private static final Logger Logger = LoggerFactory.getLogger(WebServiceConfig.class);
    private static final String DISPATCHER_SERVLET_MAPPING = "/processoEletronicoService/*";

    @Bean(name = WS_WSDL_NAME)
    public DefaultWsdl11Definition mpWsdl11Definition(XsdSchema schema) {
        final String caminhoWsdl = new StringBuilder(WS_LOCATION_URI).append("/").append(WS_WSDL_NAME).append(".wsdl").toString();

        Logger.info("Publicando o WSDL em {} ...", caminhoWsdl);
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProcessoEletronico");
        wsdl11Definition.setLocationUri(WS_LOCATION_URI);
        wsdl11Definition.setTargetNamespace("http://minhaempresa.com.br/processoeletronico/definitions");
        wsdl11Definition.setCreateSoap11Binding(true);
        wsdl11Definition.setSchema(schema);
        return wsdl11Definition;
    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        Logger.info("Criando MessageDispatcherServlet mapeado para {}.", DISPATCHER_SERVLET_MAPPING);
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, DISPATCHER_SERVLET_MAPPING);
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
