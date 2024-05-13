package wg.eventhubs.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import wg.eventhubs.model.Event;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topics.events}")
    public void receive(Event event) {
        log.info("Received message from kafka: {}", event);
    }
}
