package com.apirest.apirest01.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_persona")
public class Persona {
    @Id
    private Integer idpersona;
    private String nompersona;
    private String apepersona;
    private int idpais;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idpais", insertable = false, updatable = false)
    private Pais pais;
}
