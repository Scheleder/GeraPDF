/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerapdf;

/**
 *
 * @author jscheleder
 */
public class Auditoria {
    public int id, aval, status;
    public String ciclo, numero, site, local, auditor, auditado, texto;
    public String data, prazo, finalizado;
     public int status_01, status_02, status_03, status_04, status_05, status_06, status_07, status_08, status_09, status_10, status_11, status_12, status_13, status_14, status_15, status_16, status_17, status_18, status_19, status_20, status_21;

    public Auditoria() {
    }

    public Auditoria(int id, int aval, int status, String ciclo, String numero, String site, String local, String auditor, String auditado, String texto, String data, String prazo, String finalizado, int status_01, int status_02, int status_03, int status_04, int status_05, int status_06, int status_07, int status_08, int status_09, int status_10, int status_11, int status_12, int status_13, int status_14, int status_15, int status_16, int status_17, int status_18, int status_19, int status_20, int status_21) {
        this.id = id;
        this.aval = aval;
        this.status = status;
        this.ciclo = ciclo;
        this.numero = numero;
        this.site = site;
        this.local = local;
        this.auditor = auditor;
        this.auditado = auditado;
        this.texto = texto;
        this.data = data;
        this.prazo = prazo;
        this.finalizado = finalizado;
        this.status_01 = status_01;
        this.status_02 = status_02;
        this.status_03 = status_03;
        this.status_04 = status_04;
        this.status_05 = status_05;
        this.status_06 = status_06;
        this.status_07 = status_07;
        this.status_08 = status_08;
        this.status_09 = status_09;
        this.status_10 = status_10;
        this.status_11 = status_11;
        this.status_12 = status_12;
        this.status_13 = status_13;
        this.status_14 = status_14;
        this.status_15 = status_15;
        this.status_16 = status_16;
        this.status_17 = status_17;
        this.status_18 = status_18;
        this.status_19 = status_19;
        this.status_20 = status_20;
        this.status_21 = status_21;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAval() {
        return aval;
    }

    public void setAval(int aval) {
        this.aval = aval;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCiclo() {
      
        if (getStatus() == 0) {
            ciclo = "Por executar";
        }
        if (getStatus() == 1) {
            ciclo = "25% concluída";
        }
        if (getStatus() == 2) {
            ciclo = "50% concluída";
        }
        if (getStatus() == 3) {
            ciclo = "75% concluída";
        }
        if (getStatus() == 4) {
            ciclo = "Concluída";
        }
        if (getStatus() == 5) {
            ciclo = "Em tratamento";
        }
        if (getStatus() == 6) {
            ciclo = "Necessita suporte";
        }
        if (getStatus() == 7) {
            String fim = getFinalizado();
            fim = fim.substring(0, fim.length() - 9);
            ciclo = "Finalizada em "+fim;
        }
        return ciclo;
    
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditado() {
        return auditado;
    }

    public void setAuditado(String auditado) {
        this.auditado = auditado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(String finalizado) {
        this.finalizado = finalizado;
    }

    public int getStatus_01() {
        return status_01;
    }

    public void setStatus_01(int status_01) {
        this.status_01 = status_01;
    }

    public int getStatus_02() {
        return status_02;
    }

    public void setStatus_02(int status_02) {
        this.status_02 = status_02;
    }

    public int getStatus_03() {
        return status_03;
    }

    public void setStatus_03(int status_03) {
        this.status_03 = status_03;
    }

    public int getStatus_04() {
        return status_04;
    }

    public void setStatus_04(int status_04) {
        this.status_04 = status_04;
    }

    public int getStatus_05() {
        return status_05;
    }

    public void setStatus_05(int status_05) {
        this.status_05 = status_05;
    }

    public int getStatus_06() {
        return status_06;
    }

    public void setStatus_06(int status_06) {
        this.status_06 = status_06;
    }

    public int getStatus_07() {
        return status_07;
    }

    public void setStatus_07(int status_07) {
        this.status_07 = status_07;
    }

    public int getStatus_08() {
        return status_08;
    }

    public void setStatus_08(int status_08) {
        this.status_08 = status_08;
    }

    public int getStatus_09() {
        return status_09;
    }

    public void setStatus_09(int status_09) {
        this.status_09 = status_09;
    }

    public int getStatus_10() {
        return status_10;
    }

    public void setStatus_10(int status_10) {
        this.status_10 = status_10;
    }

    public int getStatus_11() {
        return status_11;
    }

    public void setStatus_11(int status_11) {
        this.status_11 = status_11;
    }

    public int getStatus_12() {
        return status_12;
    }

    public void setStatus_12(int status_12) {
        this.status_12 = status_12;
    }

    public int getStatus_13() {
        return status_13;
    }

    public void setStatus_13(int status_13) {
        this.status_13 = status_13;
    }

    public int getStatus_14() {
        return status_14;
    }

    public void setStatus_14(int status_14) {
        this.status_14 = status_14;
    }

    public int getStatus_15() {
        return status_15;
    }

    public void setStatus_15(int status_15) {
        this.status_15 = status_15;
    }

    public int getStatus_16() {
        return status_16;
    }

    public void setStatus_16(int status_16) {
        this.status_16 = status_16;
    }

    public int getStatus_17() {
        return status_17;
    }

    public void setStatus_17(int status_17) {
        this.status_17 = status_17;
    }

    public int getStatus_18() {
        return status_18;
    }

    public void setStatus_18(int status_18) {
        this.status_18 = status_18;
    }

    public int getStatus_19() {
        return status_19;
    }

    public void setStatus_19(int status_19) {
        this.status_19 = status_19;
    }

    public int getStatus_20() {
        return status_20;
    }

    public void setStatus_20(int status_20) {
        this.status_20 = status_20;
    }

    public int getStatus_21() {
        return status_21;
    }

    public void setStatus_21(int status_21) {
        this.status_21 = status_21;
    }

     
    
}
