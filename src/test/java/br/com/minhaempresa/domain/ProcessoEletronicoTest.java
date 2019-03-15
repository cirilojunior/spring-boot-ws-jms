package br.com.minhaempresa.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProcessoEletronicoTest {

    @Test
    public void naoDeveCriarComNumeroVazio() {
        try {
            new ProcessoEletronico(null, null, null);
            fail("Deve lançar excecção");
        } catch (Exception e) {
            assertEquals("Informe o Nro do Processo Eletrônico.", e.getMessage());
        }
    }

}
