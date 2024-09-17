package com.ligabtp.ligabetplay.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipoarbitros")
public class TipoArbitro {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;


    @Column(length = 100)
    private String principal_tipoar;

    @Column(length = 100)
    private String juezlinea_tipoar;

    @Column(length = 100)
    private String asistenteprincipal_tipoar;

    @Column(length = 100)
    private String var_tipoar;

    @Column(length = 100)
    private String asistentevar_tipoar;

}
