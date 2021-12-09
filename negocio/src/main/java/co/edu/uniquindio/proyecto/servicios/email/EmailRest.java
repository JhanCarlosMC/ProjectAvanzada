package co.edu.uniquindio.proyecto.servicios.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class EmailRest
{
    @Autowired
    private EmailPort emailPort;

    @PostMapping(value = "/send")
    @ResponseBody
    public void SendEmail(@RequestBody EmailBody emailBody) throws Exception
    {
        emailPort.sendEmail(emailBody);
    }

}