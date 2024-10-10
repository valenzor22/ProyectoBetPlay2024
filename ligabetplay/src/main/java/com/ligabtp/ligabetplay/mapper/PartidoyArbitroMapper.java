package com.ligabtp.ligabetplay.mapper;

import com.ligabtp.ligabetplay.domain.PartidoyArbitro;
import com.ligabtp.ligabetplay.dto.PartidoyArbitroDTO;

import java.util.List;

public class PartidoyArbitroMapper {

    public static PartidoyArbitro dtoToDomain(PartidoyArbitroDTO partidoyArbitroDTO){

        return PartidoyArbitro.builder()
                .id(partidoyArbitroDTO.getId())
                .tipo_arbitro(partidoyArbitroDTO.getTipoArbitro())
                .build();
    }

    public static PartidoyArbitroDTO domainToDTO(PartidoyArbitro partidoyArbitro) {

        return PartidoyArbitro.builder()
                .id(partidoyArbitro.getId())
                .tipo_arbitro(partidoyArbitro.getTipoArbitro())
                .build();
    }

    public static List<PartidoyArbitroDTO> domainToDTOList(List<PartidoyArbitro> partidoyArbitro) {
        return partidoyArbitro.stream().map(PartidoyArbitroMapper::domainToDTO).toList();
    }
}