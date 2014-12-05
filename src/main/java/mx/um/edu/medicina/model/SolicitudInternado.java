/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.um.edu.medicina.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Version;
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
//    private Plaza plaza;
    private String celular;
    private String telefono;
    private String correo;
    private String direccion;
    private String pruebas;
    private String pruebas2;
    private String pruebas3;

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

    @Field
    public Boolean getForaneo() {
        return foraneo;
    }

    @Field
    public String getPruebas() {
        return pruebas;
    }

    @Field
    public String getPruebas2() {
        return pruebas2;
    }

    @Field
    public String getPruebas3() {
        return pruebas3;
    }

//    @OneToOne
//    public Plaza getPlaza() {
//        return plaza;
//    }
    @Field
    public String getCelular() {
        return celular;
    }

    @Field
    public String getTelefono() {
        return telefono;
    }

    @Field
    public String getCorreo() {
        return correo;
    }

    @Field
    public String getDireccion() {
        return direccion;
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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

//    public void setPlaza(Plaza plaza) {
//        this.plaza = plaza;
//    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPruebas(String pruebas) {
        this.pruebas = pruebas;
    }

    public void setPruebas2(String pruebas2) {
        this.pruebas2 = pruebas2;
    }

    public void setPruebas3(String pruebas2) {
        this.pruebas2 = pruebas2;
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
        return "SolicitudInternado{" + "id=" + id + ", version=" + version + ", nombre=" + nombre + ", apPaterno=" + apPaterno
                + ", apMaterno=" + apMaterno + ", matricula=" + matricula + ", foraneo=" + foraneo + ", celular=" + celular
                + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", pruebas=" + pruebas
                + ", pruebas2=" + pruebas2 + ", pruebas3=" + pruebas3 + '}';
    }

}
