package co.edu.uniquindio.proyecto.servicios.email;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailPort
{
    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEmail(EmailBody emailBody) throws Exception
    {
        sendEmailTool(emailBody.getContent(),emailBody.getEmail(), emailBody.getSubject());
    }


    private void sendEmailTool(String textMessage, String email,String subject) throws Exception
    {
        System.out.println("Email 1");

        MimeMessage message = sender.createMimeMessage();

        System.out.println("Email 2");

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        try
        {
            System.out.println("Email 3");

            helper.setFrom("juansebastianmedinasanabria@gmail.com");
            helper.setTo(email);
            helper.setText(textMessage, true);
            helper.setSubject(subject);

            System.out.println("Email 4");

            sender.send(message);
        }
        catch (MessagingException e)
        {
            throw new Exception ("Email no enviado.");
        }
        System.out.println("Email 5");
    }
}
