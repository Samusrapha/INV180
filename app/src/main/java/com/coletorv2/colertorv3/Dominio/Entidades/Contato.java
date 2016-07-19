package com.coletorv2.colertorv3.Dominio.Entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Raphael on 05/03/2016.
 */
public class Contato implements Serializable {

    public static String TABELA = "FORMULARIO";
    public static String ID ="_id";
    public static String TALHAO ="TALHAO";
    public static String MATERIAL ="MATERIAL";
    public static String AREA ="AREA";
    public static String DATA ="DATA";
    public static String SOBREVIVENCIA  ="SOBREVIVENCIA";
    public static String DENSIDADE  ="DENSIDADE";
    public static String HOMOGENEIDADE  ="HOMOGENEIDADE";
    public static String ASPECTO ="ASPECTO";
    public static String MATO ="MATO";
    public static String FORMIGA ="FORMIGA";
    public static String PRAGAS ="PRAGAS";
    public static String CONSERVACAO ="CONSERVACAO";




    private long id;
    private String talhao;
    private String material;
    private String area;
    private Date data;
    private String sobrevivencia;
    private String densidade;
    private String homogeneidade;
    private String aspecto;
    private String mato;
    private String formiga;
    private String pragas;
    private String conservacao;

    public Contato()

    {
        id= 0;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTALHAO() {
        return talhao;
    }

    public void setTALHAO(String talhao) {
        this.talhao = talhao;
    }

    public String getMATERIAL() {
        return material;
    }

    public void setMATERIAL(String material) {
        this.material = material;
    }

    public String getAREA() {
        return area;
    }

    public void setAREA(String area) {
        this.area = area;
    }




    public Date getDATA() {
        return data;
    }

    public void setDATA(Date data) { this.data = data;}



    public String getSOBREVIVENCIA() {
        return sobrevivencia;
    }

    public void setSOBREVIVENCIA(String sobrevivencia) {
        this.sobrevivencia = sobrevivencia;
    }

    public String getDENSIDADE() {
        return densidade;
    }

    public void setDENSIDADE(String densidade) {
        this.densidade = densidade;
    }

    public String getHOMOGENEIDADE() {
        return homogeneidade;
    }

    public void setHOMOGENEIDADE(String homogeneidade) {
        this.homogeneidade = homogeneidade;
    }

    public String getASPECTO() {
        return aspecto;
    }

    public void setASPECTO(String aspecto) {
        this.aspecto = aspecto;
    }

    public String getMATO() {
        return mato;
    }

    public void setMATO(String mato) {    this.mato = mato;
    }

    public String getFORMIGA() {
        return formiga;
    }


    public void setFORMIGA(String formiga) {
        this.formiga = formiga;
    }

    public String getPRAGAS() {
        return pragas;
    }


    public void setPRAGAS(String pragas) {
        this.pragas = pragas;
    }
    public String getCONSERVACAO() {
        return conservacao;
    }


    public void setCONSERVACAO(String conservacao) {
        this.conservacao = conservacao;
    }


    @Override
    public String toString()
    {
        return talhao +""+ material;
    }
}
