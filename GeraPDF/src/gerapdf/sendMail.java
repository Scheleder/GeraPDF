/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerapdf;

import com.guilhermechapiewski.fluentmail.email.EmailMessage;
import com.guilhermechapiewski.fluentmail.transport.EmailTransportConfiguration;

/**
 *
 * @author jscheleder
 */
public class sendMail {

    public boolean send(String destinatario, String caminho) {
        /*smtp.server=my.smtp.server.com
        auth.required=true
        use.secure.smtp=false
        smtp.username=gc
        smtp.password=mypasswd*/
        EmailTransportConfiguration.configure("gmail-smtp-in.l.google.com", true, true, "neto150272@gmail.com", "js12js07vs24");

        try {
            new EmailMessage()
                    .from("neto150272@gmail.com")
                    .to(destinatario)
                    .withSubject("Relatório de Auditoria")
                    .withBody("Segue em anexo relatório de auditoria 5S.")
                    .send();
        } catch (Exception ex) {
            System.out.println("Falha na conexão ao servidor de email - "+ex);
        }

        return false;
    }

}
