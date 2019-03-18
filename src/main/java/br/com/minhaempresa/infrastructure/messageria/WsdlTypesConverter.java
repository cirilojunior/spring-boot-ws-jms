package br.com.minhaempresa.infrastructure.messageria;

import br.com.minhaempresa.domain.ListaPecas;
import br.com.minhaempresa.domain.Peca;
import br.com.minhaempresa.domain.ProcessoEletronico;
import br.com.minhaempresa.infrastructure.ws.schemas.ListaPecasType;
import br.com.minhaempresa.infrastructure.ws.schemas.PecaType;
import br.com.minhaempresa.infrastructure.ws.schemas.ProcessoEletronicoType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

@Component
public class WsdlTypesConverter {

    public ProcessoEletronico from(ProcessoEletronicoType processoEletronicoType) {

        GregorianCalendar dataHoraAsCalendar = processoEletronicoType.getDataHora().toGregorianCalendar();
        LocalDateTime dataHora = LocalDateTime.ofInstant(dataHoraAsCalendar.toInstant(), dataHoraAsCalendar.getTimeZone().toZoneId());

        ProcessoEletronico processoEletronico = new ProcessoEletronico(
                processoEletronicoType.getNumero(),
                dataHora,
                from(processoEletronicoType.getPecas())
        );
        return processoEletronico;
    }

    public Peca from(PecaType pecaType) {
        return new Peca(
                pecaType.getId(),
                pecaType.getTitulo(),
                pecaType.getOrdem(),
                pecaType.getTexto()
        );
    }

    public ListaPecas from(ListaPecasType listaPecasType) {
        ListaPecas lista = new ListaPecas();
        listaPecasType.getPeca().forEach(p -> lista.adiciona(from(p)));
        return lista;
    }
}
