package ru.artamonov.producer.service.workerService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.artamonov.producer.entity.Worker;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final KafkaTemplate<String, String> kafkaWorkerTemplate;

    @Autowired
    public WorkerServiceImpl(KafkaTemplate<String, String> kafkaStarshipTemplate) {
        this.kafkaWorkerTemplate = kafkaStarshipTemplate;
    }

    @Override
    public void saveWorker(Worker worker) {
        kafkaWorkerTemplate.send("workerTopic", "CREATE", convertToJson(worker));

        System.out.println("save=\t" + worker);
    }

    @Override
    public void saveAllWorkers(List<Worker> workers) {
        kafkaWorkerTemplate.send("workerListTopic", "CREATE", convertToJson(workers));

        System.out.println("save=\t" + workers);
    }

    private String convertToJson(Worker worker) {
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonWorker = null;
        try {
            jsonWorker = objectMapper.writeValueAsString(worker);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonWorker;
    }

    private String convertToJson(List<Worker> workers) {
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonWorkers = null;
        try {
            jsonWorkers =  objectMapper.writeValueAsString(workers);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonWorkers;
    }
}
