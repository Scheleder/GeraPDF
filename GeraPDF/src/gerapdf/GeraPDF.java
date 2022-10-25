/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerapdf;


import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author jscheleder
 */
public class GeraPDF extends javax.swing.JFrame {

    Timer tempo;
    int intervalo = 30000;
    int index_auditoria;
    int index_inconformidade;
    Auditoria auditoria;
    Auditor auditor;
    Auditado auditado;
    Foto foto;
    String agora;
    Date hoje;
    Float DocHeight;
    String stringLog;

    /**
     * Creates new form GeraPDF
     */
    public GeraPDF() {
        initComponents();
        this.setName("GeraPDF");
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icon-pdf.png")).getImage());
        stringLog = "";
        auditoria = new Auditoria();
        auditoria.setNumero("|");
        toLog("Aplicação iniciada.");
        tempo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-pdf.png"))); // NOI18N
        jButton1.setText(" GERAR PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtLog.setEditable(false);
        txtLog.setBackground(new java.awt.Color(240, 240, 240));
        txtLog.setColumns(20);
        txtLog.setLineWrap(true);
        txtLog.setRows(5);
        txtLog.setToolTipText("log");
        txtLog.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtLog.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(txtLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "Gera PDF, by Scheleder.");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GeraPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeraPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeraPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeraPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeraPDF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables

    private void tempo() {
        tempo = new Timer(intervalo, (ActionEvent e) -> {
            tempo.stop();
            principal();
        } //vai esperar intervalo e executar essa ação
        );
        tempo.start();
    }

    public void principal() {
        //hoje = (new Date());
        //SimpleDateFormat df = new SimpleDateFormat("EE dd/MM/yyyy" + " - " + "HH:mm");
        //agora = df.format(hoje);
        index_auditoria = 0;
        index_inconformidade = 0;
        //busca auditorias finalizadas       
        AuditDAO dao1 = new AuditDAO();
        while (dao1.findFinalizadas() == false) {
        }
        if (AuditDAO.auditorias.size() > 0) {
            mudaAuditoria();
        } else {
            System.out.println("Sem novas auditorias finalizadas");
            tempo.start();
        }
    }

    public void mudaAuditoria() {
        auditoria = AuditDAO.auditorias.get(index_auditoria);
        if (!new File("c:\\wamp64\\www\\audit\\pdf\\" + auditoria.numero + ".pdf").exists()) {

            System.out.println("Auditoria " + auditoria.numero);
            //System.out.println("Auditor " + auditoria.auditor);
            //System.out.println("Auditado " + auditoria.auditado);
            //busca dados do Auditor
            AuditDAO dao2 = new AuditDAO();
            while (dao2.findAuditor(auditoria.auditor) == false) {
            }
            auditor = AuditDAO.auditores.get(0);
            System.out.println("Auditor");
            System.out.println("Matricula " + auditor.matricula);
            System.out.println("Nome " + auditor.nome);
            System.out.println("Mail " + auditor.mail);
            //busca dados do Auditado
            AuditDAO dao3 = new AuditDAO();
            while (dao3.findAuditado(auditoria.auditado) == false) {
            }
            auditado = AuditDAO.auditados.get(0);
            System.out.println("Auditado");
            System.out.println("Matricula " + auditado.matricula);
            System.out.println("Nome " + auditado.nome);
            System.out.println("Mail " + auditado.mail);
            System.out.println("-----------------------------------------");

            leInconformidades();
        } else {
            System.out.println("O arquivo " + auditoria.numero + ".pdf já existe!");
            System.out.println("-----------------------------------------");

            //proxima auditoria ou entra em espera
            if (index_auditoria < AuditDAO.auditorias.size() - 1) {
                index_auditoria++;
                index_inconformidade = 0;
                mudaAuditoria();
            } else {
                tempo.start();
                System.out.println("Wait4more");
                System.out.println("-----------------------------------------");
                gravaLog();
            }
        }
    }

    public void leInconformidades() {
        AuditDAO dao4 = new AuditDAO();
        while (dao4.findInconf(auditoria.numero) == false) {
        }
        gravaHTML();
    }

    public void criaRelatorio() {
        System.out.println("Gerando novo pdf...");
     try {
        File htmlSource = new File("c:\\wamp64\\www\\audit\\html\\" + auditoria.numero + ".html");
        File pdfDest = new File("c:\\wamp64\\www\\audit\\pdf\\" + auditoria.numero + ".pdf");
         // pdfHTML specific code
        ConverterProperties converterProperties = new ConverterProperties();
   
            HtmlConverter.convertToPdf(new FileInputStream(htmlSource),
                    new FileOutputStream(pdfDest), converterProperties);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeraPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeraPDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Arquiva a auditoria se for mais antiga que 30 dias
        //if(agora>auditoria.finalizado+30 dias)
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFim = null;
        try {
            dataFim = df1.parse(auditoria.finalizado);
        } catch (ParseException ex) {
            Logger.getLogger(GeraPDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Adiciona 1 mes a data
        Calendar calB = Calendar.getInstance();
        calB.setTime(dataFim);
        calB.add(Calendar.MONTH, 1);
        dataFim = calB.getTime();
        //System.out.println("Agora: " + Calendar.getInstance().getTime());
        //System.out.println("Finalizado mais 30: " + dataFim);
        if (Calendar.getInstance().getTime().after(dataFim)) {
            AuditDAO dao5 = new AuditDAO();
            while (dao5.updateStatus(auditoria.numero) == false) {
            }
            System.out.println("Auditoria " + auditoria.numero + " arquivada");
            toLog("Auditoria arquivada");
            System.out.println("-----------------------------------------");
        }

        System.out.println("...feito!");
        System.out.println("arquivo " + auditoria.numero + ".pdf criado!");
        toLog("arquivo " + auditoria.numero + ".pdf criado!");
        System.out.println("-----------------------------------------");
        System.out.println(index_auditoria + " - " + (AuditDAO.auditorias.size() - 1));

        //Envia o relatório por e-mail
        //sendMail send = new sendMail();
        //while (send.send("scheleder@yahoo.com", "c:\\wamp64\\www\\audit\\pdf\\" + auditoria.numero + ".pdf")) {
        //}
        //proxima auditoria ou entra em espera
        System.out.println("index " + index_auditoria + " - lista.size() " + AuditDAO.auditorias.size());
        if (index_auditoria < AuditDAO.auditorias.size() - 1) {
            index_auditoria++;
            index_inconformidade = 0;
            mudaAuditoria();
        } else {
            tempo.start();
            System.out.println("Wait4more");
            System.out.println("-----------------------------------------");

        }

    }

    private void toLog(String texto) {
        hoje = (new Date());
        SimpleDateFormat df = new SimpleDateFormat("EE dd/MM/yyyy" + " - " + "HH:mm:ss");
        agora = df.format(hoje);
        txtLog.setText(txtLog.getText() + "\n " + agora + " - " + auditoria.numero + " - " + texto);
        stringLog = stringLog + "\n " + agora + " - " + auditoria.numero + " - " + texto;
    }

    private void gravaLog() {
        if (!stringLog.equals("")) {
            System.out.println("gravando log...");
            FileWriter salvar = null;
            try {
                salvar = new FileWriter(new File("c:\\wamp64\\www\\audit\\log\\log.txt"), true);
                PrintWriter out = new PrintWriter(salvar);
                out.println(stringLog);
                salvar.flush();
                salvar.close();
            } catch (IOException ex) {
                Logger.getLogger(GeraPDF.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("erro " + ex);
            }
            System.out.println("...feito!");
            stringLog = "";
        }
    }

    private void gravaHTML() {
        System.out.println("gerando html...");
        FileWriter salvar = null;
        String dt = auditoria.data;
        dt = dt.substring(0, dt.length() - 9);
        String fz = auditoria.finalizado;
        fz = fz.substring(0, fz.length() - 9);
        int av = auditoria.aval;
        av = (int) (av * 100 / 210);
        
        BarcodeQRCode barcodeQRCode = new BarcodeQRCode("http://10.179.60.204:8080/audit/pdf/" + auditoria.numero + ".html");
        Image codeQrImage = barcodeQRCode.createAwtImage(Color.BLACK, Color.WHITE);
        //codeQrImage.scaleAbsolute(100, 100);
        

        try {
            salvar = new FileWriter(new File("c:\\wamp64\\www\\audit\\html\\" + auditoria.numero + ".html"), false);
            PrintWriter out = new PrintWriter(salvar);

            out.println("<!doctype html>\n"
                    + "<html lang=\"en\" class=\"no-js\">\n"
                    + "<head>\n"
                    + "    <meta charset=\"utf-8\">\n"
                    + "    <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n"
                    + "    <link rel=\"canonical\" href=\"https://html5-templates.com/\" />\n"
                    + "    <title>Relatório de Auditoria 5S</title>\n"
                    + "    <meta name=\"description\" content=\"Resultados de Auditoria\">\n"
                    + "    <link rel=\"stylesheet\" href=\"http://10.179.60.204:8080/audit/html/style.css\">\n"
                    + "    <script src=\"script.js\"></script>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "	<header>\n"
                    + "	<div id=\"logo\"><img src=\"http://10.179.60.204:8080/audit/berry.png\"></div>\n"
                    + "	<nav>  \n"
                    + "	<ul>\n"
                    + "	<li><a href=\"http://10.179.60.204:8080/audit/pdf/"+auditoria.numero+".pdf\">RELATÓRIO DE AUDITORIA 5S</a>\n"
                    + "	</ul>\n"
                    + "	</nav>\n"
                    + "	</header>\n"
                    + "	\n"
                    + "	<section id=\"pageContent\">\n"
                    + "	<main role=\"main\">\n"
                    + "	<aside>\n"
                    + "	<div>Auditoria número: " + auditoria.numero + "\n"
                    + "<br>Local: " + auditoria.site + " - " + auditoria.local + "\n"
                    + "<br>Descrição: " + auditoria.texto + "\n"
                    + "<br>Auditor: " + auditor.matricula + " - " + auditor.nome + "\n"
                    + "<br>Auditado: " + auditado.matricula + " - " + auditado.nome + "\n"
                    + "<br>Criada em: " + dt + "\n"
                    + "<br>Finalizada em: " + fz + "\n"
                    + "<br>Número de não-conformidades: " + AuditDAO.fotos.size() + "\n"
                    + "<br>Avaliação: " + av + "%\n"
                    + "</div>\n" + "</aside>\n"
                    + "<article>\n"
                    + "<h2></h2>\n"
                    + "</article>");

            if (AuditDAO.fotos.size() > 0) {

                for (index_inconformidade = 0; index_inconformidade < AuditDAO.fotos.size(); index_inconformidade++) {
                    foto = AuditDAO.fotos.get(index_inconformidade);

                    out.println("\n "
                            + "<article><h2>Não-conformidade \n"
                            + (index_inconformidade + 1) + "/"
                            + AuditDAO.fotos.size()
                            + ", item " + foto.item
                            + ", evidência:</h2>\n"
                            + "<div id=\"foto\"><img src=\"http://10.179.60.204:8080/audit/upload/" + foto.arquivo + "\" alt=\"evidencia\"</img></div>\n"
                            + "<h2>Histórico</h2>\n");
                    out.println("<pre>" + foto.hist + "</pre>");
                    out.println("</article>");

                }
            } else {
                out.println("<article>\n"
                        + "<h2>Não-conformidades inexistentes.</h2>\n"
                        + "</article>\n");
            }
            out.println("</main>\n"
                    + "		<section>\n"
                    + "		<h4>Gerado automaticamente pelo sistema em: " + agora + ".</h4>\n"
                    + "	</section>\n"
                    + "		\n"
                    + "	</section>\n"
                    + "	<footer>\n"
                    + "		<p>&copy;  <a href=\"http://www.berryglobal.com//\" target=\"_blank\" rel=\"nofollow\">www.berryglobal.com</a></p>\n"
                    + "	</footer>\n"
                    + "\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>");

            salvar.flush();
            salvar.close();
        } catch (IOException ex) {
            Logger.getLogger(GeraPDF.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro " + ex);
        }
        System.out.println("...feito!");
        System.out.println("Arquivo " + auditoria.numero + ".html gerado.");
        toLog("Arquivo " + auditoria.numero + ".html gerado.");
        criaRelatorio();
    }

}