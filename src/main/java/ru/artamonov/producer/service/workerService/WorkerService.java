package ru.artamonov.producer.service.workerService;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.artamonov.producer.entity.Worker;

import java.util.List;

public interface WorkerService {

    void saveWorker(Worker worker);

    void saveAllWorkers(List<Worker> workers);

    Object getWorkerById(Long workerId);

    void updateWorkerById(Long workerId, Worker worker);

    void deleteWorkerById(Long workerId);
}
