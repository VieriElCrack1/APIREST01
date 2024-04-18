package com.apirest.apirest01.model.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "tb_pais")
public class Pais {
    @Id
    private Integer idpais;
    private String nompais;

    @OneToMany(mappedBy = "pais")
    private List<Persona> lstPersona;
}
