package wg.eventhubs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import wg.eventhubs.model.Event;
import wg.eventhubs.producer.KafkaProducer;

@RestController
public class EventController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addEvent(@RequestBody Event event) {
        kafkaProducer.send(event);
    }
}
