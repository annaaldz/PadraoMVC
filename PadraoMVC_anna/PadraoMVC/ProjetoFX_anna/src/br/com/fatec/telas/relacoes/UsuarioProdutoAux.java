package br.com.fatec.telas.relacoes;

/**
 * FXML Controller class
 *
 * @author Anna Carolina
 * FATEC Carapicuíba
 * @version 1.1
 * 
 */
public class UsuarioProdutoAux {
    private int id;
    private int idU;
    private int idP;
    private String obs;
    private String loginUsuario;
    private String nomeProduto;

    public UsuarioProdutoAux() {
    }

    public UsuarioProdutoAux(int id, int idU, int idP, String obs, String loginUsuario, String nomeProduto) {
        this.id = id;
        this.idU = idU;
        this.idP = idP;
        this.obs = obs;
        this.loginUsuario = loginUsuario;
        this.nomeProduto = nomeProduto;
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

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
