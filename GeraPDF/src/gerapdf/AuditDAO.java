/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerapdf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jscheleder
 */
public class AuditDAO {

    static List<Auditoria> auditorias = new ArrayList<>();
    static List<Auditor> auditores = new ArrayList<>();
    static List<Auditado> auditados = new ArrayList<>();
    static List<Foto> fotos = new ArrayList<>();

    private Connection con = null;

    public AuditDAO() {

        con = ConnectionFactory.getConnection();

    }

    public boolean findFinalizadas() {
        boolean fimLeitura;
        String SQL = "SELECT * FROM auditoria.audit WHERE status=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        auditorias.clear();
        try {
            stmt = con.prepareStatement(SQL);
            stmt.setInt(1, 7);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Auditoria auditoria = new Auditoria();

                auditoria.setId(rs.getInt("id"));
                auditoria.setAval(rs.getInt("aval"));
                auditoria.setStatus(rs.getInt("status"));
                auditoria.setNumero(rs.getString("numero"));
                auditoria.setSite(rs.getString("site"));
                auditoria.setLocal(rs.getString("local"));
                auditoria.setNumero(rs.getString("numero"));
                auditoria.setAuditor(rs.getString("auditor"));
                auditoria.setAuditado(rs.getString("auditado"));
                auditoria.setTexto(rs.getString("texto"));
                auditoria.setData(rs.getString("data"));
                auditoria.setPrazo(rs.getString("prazo"));
                auditoria.setFinalizado(rs.getString("finalizado"));
                auditorias.add(auditoria);
                System.out.println(auditoria.numero);
            }

        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            System.out.println("-----------------------------------------");
            ConnectionFactory.closeConnection(con, stmt, rs);
            fimLeitura = true;
        }
        return fimLeitura;
    }

    public boolean findInconf(String numero) {
        boolean fimLeitura;
        String SQL = "SELECT * FROM fotos WHERE numero=? order by item";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        fotos.clear();
        try {
            stmt = con.prepareStatement(SQL);
            stmt.setString(1, numero);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Foto foto = new Foto();

                foto.setNumero(rs.getString("numero"));
                foto.setArquivo(rs.getString("foto"));
                foto.setHist(rs.getString("hist"));
                foto.setItem(rs.getInt("item"));
                foto.setAction(rs.getInt("action"));
                foto.setInc(rs.getInt("inc"));
                fotos.add(foto);
                System.out.println("Numero: "+foto.numero);
                System.out.println("Item: "+foto.item);
                System.out.println("Arquivo: "+foto.arquivo);
                System.out.println("-----------------------------------------");
            }

        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            fimLeitura = true;
        }
        return fimLeitura;
    }

    public boolean findAuditor(String nome) {
        boolean fimLeitura = false;
        String SQL = "SELECT * FROM auditor WHERE nome=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        auditores.clear();
        try {
            stmt = con.prepareStatement(SQL);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Auditor auditor = new Auditor();

                auditor.setMatricula(rs.getString("matricula"));
                auditor.setNome(rs.getString("nome"));
                auditor.setTipo(rs.getString("tipo"));
                auditor.setMail(rs.getString("mail"));
                auditores.add(auditor);
            }

        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            fimLeitura = true;
        }
        return fimLeitura;
    }

    public boolean findAuditado(String nome) {
        boolean fimLeitura = false;
        String SQL = "SELECT * FROM auditado WHERE nome=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        auditados.clear();
        try {
            stmt = con.prepareStatement(SQL);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Auditado auditado = new Auditado();

                auditado.setMatricula(rs.getString("matricula"));
                auditado.setNome(rs.getString("nome"));
                auditado.setTipo(rs.getString("tipo"));
                auditado.setMail(rs.getString("mail"));
                auditados.add(auditado);
            }

        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            fimLeitura = true;
        }
        return fimLeitura;
    }

    public boolean updateStatus(String numero) {
        boolean fimLeitura = false;
        String SQL = "UPDATE audit SET status = ? WHERE numero = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(SQL);
            stmt.setInt(1, 8);
            stmt.setString(2, numero);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
             fimLeitura = true;
        }
        return fimLeitura;
    }
    
}
