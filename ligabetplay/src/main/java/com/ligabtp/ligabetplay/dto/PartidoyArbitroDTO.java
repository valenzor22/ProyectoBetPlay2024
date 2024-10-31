package com.ligabtp.ligabetplay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartidoyArbitroDTO {
    private Integer id;
    private String tipoArbitro;  // le agregue este porque estaba en el domain y aca no
    private Integer partidoId;   // tambien la agregue
    private Integer arbitroId;   // tambien la agregue
}
