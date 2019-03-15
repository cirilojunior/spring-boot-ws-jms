package br.com.minhaempresa.application.integracao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class MessageriaErrorHandler implements ErrorHandler {

    private static final Logger Logger = LoggerFactory.getLogger(MessageriaErrorHandler.class);

    @Override
    public void handleError(Throwable t) {
        Logger.error("Error Message : {}", t.getMessage());
    }

}
