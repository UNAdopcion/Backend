package com.unadopcion.unadopcion.modelo;

import javax.persistence.*;

@Entity
@Table( name = "animal_vacuna")
public class AnimalVacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int animVacId;
    private int animId;
    private int vacunaId;
    private int vetId;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] vacunaFoto;

    public int getAnimVacId() { return animVacId; }

    public void setAnimVacId(int animVacId) { this.animVacId = animVacId; }

    public int getAnimId() { return animId; }

    public void setAnimId(int animId) { this.animId = animId; }

    public int getVacunaId() { return vacunaId; }

    public void setVacunaId(int vacunaId) { this.vacunaId = vacunaId; }

    public int getVetId() { return vetId; }

    public void setVetId(int vetId) { this.vetId = vetId; }

    public byte[] getVacunaFoto() { return vacunaFoto; }

    public void setVacunaFoto(byte[] vacunaFoto) { this.vacunaFoto = vacunaFoto; }

}
