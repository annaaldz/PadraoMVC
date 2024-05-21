/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.bean;

import java.io.Serializable;

/**
 *
 * @author Anna Carolina
 */
public class UsuarioVeiculo implements Serializable{
    
    private int id;
    private int idU;
    private int idV;
    private String obs;
    private String login;
    private String veiculo;

    public UsuarioVeiculo(int id) {
        this.id = id;
    }

    public UsuarioVeiculo(String obs) {
        this.obs = obs;
    }

    public UsuarioVeiculo(int idU, int idV, String obs) {
        this.idU = idU;
        this.idV = idV;
        this.obs = obs;
    }

    public UsuarioVeiculo(int id, int idU, int idV, String obs) {
        this.id = id;
        this.idU = idU;
        this.idV = idV;
        this.obs = obs;
    }

    public UsuarioVeiculo(int id, int idU, int idV, String obs, String login, String veiculo) {
        this.id = id;
        this.idU = idU;
        this.idV = idV;
        this.obs = obs;
        this.login = login;
        this.veiculo = veiculo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }
    
    @Override
    public String toString() {
        return "UsuarioVeiculo{" + "id=" + id + ", idU=" + idU + ", idV=" + idV + ", obs=" + obs + '}';
    }
}