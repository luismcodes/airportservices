package com.luismcodes.notification.listener;

import com.luismcodes.notification.entity.Notification;
import com.luismcodes.notification.service.NotificationService;
import com.luismcodes.notification.util.NotificationReferentialUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class NotificationKafkaListener {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(topics = "${topic.name.consumer}", groupId="${spring.kafka.consumer.group-id}", autoStartup = "true")
    public void consumeMessage(String message) throws IOException {
        log.info("Kafka Consumer Data ->" + message);

        Notification notification = new Notification(1, message);

        log.info("Call service to save notification");

        notificationService.saveNotification(notification);

        log.info("Notification pushed into db");
    }
}
