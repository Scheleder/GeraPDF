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
public class Auditor {
    public String matricula;
    public String nome;
    public String tipo;
    public String mail;

    public Auditor() {
    }

    public Auditor(String matricula, String nome, String tipo, String mail) {
        this.matricula = matricula;
        this.nome = nome;
        this.tipo = tipo;
        this.mail = mail;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
