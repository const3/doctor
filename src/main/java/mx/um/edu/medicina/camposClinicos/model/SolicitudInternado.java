/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.um.edu.medicina.camposClinicos.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.Version;
import mx.um.edu.medicina.model.BaseObject;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author develop
 */
@Entity
public class SolicitudInternado extends BaseObject {

    private Long id;
    private Integer version;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String matricula;
    private Boolean foraneo;
    private Plaza plaza;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    @Version
    public Integer getVersion() {
        return version;
    }

    @Column(nullable = false, length = 50)
    @Field
    public String getNombre() {
        return nombre;
    }

    @Column(nullable = false, length = 50)
    @Field
    public String getApPaterno() {
        return apPaterno;
    }

    @Column(nullable = false, length = 50)
    @Field
    public String getApMaterno() {
        return apMaterno;
    }

    @Column(nullable = false, length = 7)
    @Field
    public String getMatricula() {
        return matricula;
    }

    @Field
    public Boolean isForaneo() {
        return foraneo;
    }

    @OneToOne
    public Plaza getPlaza() {
        return plaza;
    }

    /**
     * Returns the full name.
     *
     * @return firstName + ' ' + lastName
     */
    @Transient
    public String getFullName() {
        return nombre + ' ' + apPaterno + ' ' + apMaterno;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setForaneo(Boolean foraneo) {
        this.foraneo = foraneo;
    }

    public void setPlaza(Plaza plaza) {
        this.plaza = plaza;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SolicitudInternado other = (SolicitudInternado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolicitudInternado{" + "id=" + id + ", nombre=" + nombre + ", apPaterno=" + apPaterno
                + ", apMaterno=" + apMaterno + ", matricula=" + matricula + ", foraneo=" + foraneo + '}';
    }

}
