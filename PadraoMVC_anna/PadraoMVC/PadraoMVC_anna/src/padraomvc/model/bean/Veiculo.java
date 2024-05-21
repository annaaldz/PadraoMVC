package padraomvc.model.bean;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anna Carolina
 */
public class Veiculo implements Serializable {
    
    private int id;
    private String modelo;
    private String cor;
    
    public Veiculo(int id) {
        this.id = id;
    }

    public Veiculo(String modelo) {
        this.modelo = modelo;
    }

    public Veiculo(String modelo, String cor) {
        this.modelo = modelo;
        this.cor = cor;
    }

    public Veiculo(int id, String modelo, String cor) {
        this.id = id;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Veiculo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
     @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", modelo=" + modelo + ", cor=" + cor +'}';
    }
}
