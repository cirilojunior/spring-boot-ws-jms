package br.com.minhaempresa.infrastructure.messageria;

import br.com.minhaempresa.application.processoeletronico.RecuperarPecaProcessoEletronico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

public class RecuperarDocumentoMessageConverter implements MessageConverter {

    private static final Logger Logger = LoggerFactory.getLogger(RecuperarDocumentoMessageConverter.class);

    @Override
    public Message toMessage(Object obj, Session session) throws JMSException, MessageConversionException {
        Logger.info("Convertendo mensagem para colocar na fila o ID do Documento {}.", ((RecuperarPecaProcessoEletronico) obj).getIdDocumento().toString());

        ObjectMessage message = session.createObjectMessage((Serializable) obj);
        return message;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        RecuperarPecaProcessoEletronico obj = (RecuperarPecaProcessoEletronico) ((ObjectMessage) message).getObject();

        Logger.info("Convertendo mensagem da fila ID do Documento {} para {}.", obj.getIdDocumento(), RecuperarPecaProcessoEletronico.class.getSimpleName());
        return obj;
    }

}
