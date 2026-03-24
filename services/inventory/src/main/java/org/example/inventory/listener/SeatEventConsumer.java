package org.example.inventory.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.inventory.dto.SeatStatusEvent;
import org.example.inventory.service.SeatService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SeatEventConsumer {
    private final SeatService seatService;

    @KafkaListener(topics = "seat-events", groupId = "inventory-group")
    public void handleSeatReservation(ConsumerRecord<String, SeatStatusEvent> record) {
        SeatStatusEvent event = record.value();
        log.info("Получено событие {} для места {}. Ключ: {}, Partition: {}",
                event.type(), event.seatId(), record.key(), record.partition());

        switch (event.type()) {
            case RESERVED, CONFIRMED -> seatService.updateSeatReservation(event.seatId(), true);
            case RELEASED -> seatService.updateSeatReservation(event.seatId(), false);
            default -> log.warn("Неизвестный тип события: {}", event.type());
        }
    }

}
