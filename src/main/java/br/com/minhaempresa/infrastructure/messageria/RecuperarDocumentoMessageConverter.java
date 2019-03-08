package br.com.minhaempresa.infrastructure.messageria;

import br.com.minhaempresa.application.processoeletronico.RecuperarPecaProcessoEletronico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

public class RecuperarDocumentoMessageConverter implements MessageConverter {

    private static final Logger Logger = LoggerFactory.getLogger(RecuperarDocumentoMessageConverter.class);

    @Override
    public Message toMessage(Object idDocumento, Session session) throws JMSException, MessageConversionException {
        Logger.info("Convertendo mensagem para colocar na fila o ID do Documento {}.", idDocumento.toString());

        TextMessage textMessage = session.createTextMessage(idDocumento.toString());
        return textMessage;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        String idDocumento = ((TextMessage) message).getText();

        Logger.info("Convertendo mensagem da fila ID do Documento {} para {}.", idDocumento, RecuperarPecaProcessoEletronico.class.getSimpleName());
        return new RecuperarPecaProcessoEletronico(idDocumento);
    }

}
