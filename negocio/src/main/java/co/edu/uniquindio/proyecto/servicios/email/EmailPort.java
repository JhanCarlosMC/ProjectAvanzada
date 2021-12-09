package co.edu.uniquindio.proyecto.servicios.email;

public interface EmailPort
{
    void sendEmail(EmailBody emailBody)throws Exception;
}
