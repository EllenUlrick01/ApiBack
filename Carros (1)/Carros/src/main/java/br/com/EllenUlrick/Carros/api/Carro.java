package br.com.EllenUlrick.Carros.api;

import java.time.LocalDate;

public class Carro {

    private static int idmarca;
    private String marca;
    private int idCarro;
    private String nome;

    private int anodeFrabricacao;
    private int anoModeloDoCarro;
    
    private int idCor;
    private String nomeCor;
    private LocalDate creationDate;


    public Carro(int idmarca, String Marca, int idCarro, String nome, int anodeFrabricacao, int anoModeloDoCarro,String nomeCor, int idCor, LocalDate creationDate) {
        this.idmarca = idmarca;
        this.marca = marca;
        this.idCarro = idCarro;
        this. nome = nome;
        this.anodeFrabricacao = anodeFrabricacao;
        this.anoModeloDoCarro = anoModeloDoCarro;
        this.idCor=idCor;
        this.nomeCor=nomeCor;
        this.creationDate = creationDate;
    }

    
    public Carro(int counter, int idMarca2, String marca2, int getidCarro, String nome2, int idCor2, String nomeCor2,
            LocalDate date) {
        
    }


    public static int getIdMarca() { return idmarca; }

    public void setIdMarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getidCarro() {
        return idCarro;
    }

    public void setidCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeFrabricacao() {
        return anodeFrabricacao;
    }
    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    public int getidCor() {
        return idCor;
    }
    public void setnomeCor(String nomeCor) {
        this.nomeCor = nomeCor;
    }

    public String getnomeCor() {
        return nomeCor;
    }


    public void put(int counter, Carro newCarro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }


    public Carro get(int getidCarro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    public Carro delete(int getidCarro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    public Carro remove(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }


    public static Object values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }


}



