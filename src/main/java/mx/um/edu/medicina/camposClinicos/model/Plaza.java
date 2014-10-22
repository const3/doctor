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
import javax.persistence.Version;
import mx.um.edu.medicina.model.BaseObject;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author develop
 */
@Entity
public class Plaza extends BaseObject {

    private Long id;
    private Integer version;
    private String nombre;
    private String hubicacion;
    private String telefono;
    private String estado;
    private String pais;

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

    @Column(nullable = false, length = 150)
    @Field
    public String getHubicacion() {
        return hubicacion;
    }

    @Column(nullable = false, length = 10)
    @Field
    public String getTelefono() {
        return telefono;
    }

    @Column(nullable = false, length = 50)
    @Field
    public String getEstado() {
        return estado;
    }

    @Column(nullable = false, length = 50)
    @Field
    public String getPais() {
        return pais;
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

    public void setHubicacion(String hubicacion) {
        this.hubicacion = hubicacion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.hubicacion);
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
        final Plaza other = (Plaza) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.hubicacion, other.hubicacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plazas{" + "id=" + id + ", nombre=" + nombre + ", hubicacion=" + hubicacion + ", telefono=" + telefono
                + ", estado=" + estado + ", pais=" + pais + '}';
    }

}
