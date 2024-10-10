package com.ligabtp.ligabetplay.mapper;

import com.ligabtp.ligabetplay.domain.Arbitro;
import com.ligabtp.ligabetplay.dto.ArbitroDTO;

import java.util.List;

public class ArbitroMapper {

    public static Arbitro dtoToDomain(ArbitroDTO arbitroDTO){

        return Arbitro.builder()
                .id(arbitroDTO.getId())
                .nombre(arbitroDTO.getNombre())
                .apellido(arbitroDTO.getApellido())
                .nacionalidad(arbitroDTO.getNacionalidad())
                .fecha_nacimiento(arbitroDTO.getFecha_nacimiento())
                .build();
    }

    public static ArbitroDTO domainToDTO(Arbitro arbitro) {

        return ArbitroDTO.builder()
                .id(arbitro.getId())
                .nombre(arbitro.getNombre())
                .apellido(arbitro.getApellido())
                .nacionalidad(arbitro.getNacionalidad())
                .fecha_nacimiento(arbitro.getFecha_nacimiento())
                .build();
    }

    public static List<ArbitroDTO> domainToDTOList(List<Arbitro> arbitros) {
        return arbitros.stream().map(ArbitroMapper::domainToDTO).toList();
    }
}


