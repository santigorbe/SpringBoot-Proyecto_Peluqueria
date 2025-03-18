package org.example.peluqueria.email;

import org.example.peluqueria.kafka.order.Product;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendTurnoConfirmationEmail(
            String emailUsuario,
            String nombreUsuario,
            String nombrePeluquero,
            String apellidoPeluquero,
            String diaHorario
    ) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        messageHelper.setFrom("santigorbe@gmail.com");

        final String templateName = "turno-confirmation.html";

        Map<String, Object> variables = new HashMap<>();
        variables.put("nombreUsuario", nombreUsuario);
        variables.put("nombrePeluquero", nombrePeluquero);
        variables.put("apellidoPeluquero", apellidoPeluquero);
        variables.put("diaHorario", diaHorario);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject("Turno confirmation");

        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(emailUsuario);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s ", emailUsuario, templateName));
        } catch (MessagingException e) {
            log.warn("WARNING - Cannot send Email to {} ", emailUsuario);
        }
    }
}
