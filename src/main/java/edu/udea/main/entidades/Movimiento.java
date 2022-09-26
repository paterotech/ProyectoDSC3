package edu.udea.main.entidades;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    private String concepto;
    private float ingreso;
    private float egreso;
    private String idEmpleado;
    private String idEmpresa;
    private LocalDate createdAt;
    private LocalDate updateAt;

    public Movimiento() {
    }

    public Movimiento(long id, String concepto, float ingreso, float egreso, String idEmpleado, String idEmpresa, LocalDate createdAt, LocalDate updateAt) {
        this.id = id;
        this.concepto = concepto;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.idEmpleado = idEmpleado;
        this.idEmpresa = idEmpresa;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getIngreso() {
        return ingreso;
    }

    public void setIngreso(float ingreso) {
        this.ingreso = ingreso;
    }

    public float getEgreso() {
        return egreso;
    }

    public void setEgreso(float egreso) {
        this.egreso = egreso;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDate updateAt) {
        this.updateAt = updateAt;
    }
}
