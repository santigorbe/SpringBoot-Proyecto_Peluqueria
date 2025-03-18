package org.example.peluqueria.kafka;

import org.example.peluqueria.email.EmailService;
import org.example.peluqueria.kafka.order.OrderConfirmation;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.peluqueria.notification.TurnoConfirmation;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationsConsumer {

    private final EmailService emailService;

    @KafkaListener(topics = "turno-topic")
    public void consumeTurnoConfirmationNotifications(TurnoConfirmation turnoConfirmation) throws MessagingException {
        log.info(format("Consuming the message from order-topic Topic:: %s", turnoConfirmation));
        emailService.sendTurnoConfirmationEmail(
                turnoConfirmation.emailUsuario(),
                turnoConfirmation.nombreUsuario(),
                turnoConfirmation.nombrePeluquero(),
                turnoConfirmation.apellidoPeluquero(),
                turnoConfirmation.diaHorario()
        );
    }
}
