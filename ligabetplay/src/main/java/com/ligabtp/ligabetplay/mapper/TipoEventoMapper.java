package com.ligabtp.ligabetplay.mapper;

import com.ligabtp.ligabetplay.domain.TipoEvento;
import com.ligabtp.ligabetplay.dto.TipoEventoDTO;

import java.util.List;

public class TipoEventoMapper {

    public static TipoEvento dtoDomain (TipoEventoDTO tipoEventoDTO){

        return TipoEvento.builder()
                .id(tipoEventoDTO.getId())
                .nombre(tipoEventoDTO.getNombre())
                .build();
    }

    public static TipoEventoDTO domainToDTO (TipoEvento tipoEvento){

        return TipoEventoDTO.builder()
                .id(tipoEvento.getId())
                .nombre(tipoEvento.getNombre())
                .build();
    }

public static List<TipoEventoDTO> domainToDTOList (List<TipoEvento> tipoEventos){
        return tipoEventos.stream().map(TipoEventoMapper::domainToDTO).toList();
}
}
