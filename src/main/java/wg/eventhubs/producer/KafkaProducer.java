package wg.eventhubs.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import wg.eventhubs.model.Event;

@Slf4j
@Component
public class KafkaProducer {

    @Value("${kafka.topics.events}")
    private String eventsTopic;

    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    public void send(Event event) {
        kafkaTemplate.send(eventsTopic, event.id().toString(), event);
        log.info("Published message to kafka topic: {}", eventsTopic);
    }
}
