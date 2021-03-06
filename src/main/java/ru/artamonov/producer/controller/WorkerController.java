package ru.artamonov.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.artamonov.producer.entity.Worker;
import ru.artamonov.producer.service.workerService.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PutMapping("/save")
    public void save(@RequestBody Worker worker) {
        workerService.saveWorker(worker);
    }

    @PutMapping("/saveAll")
    public void saveAll(@RequestBody List<Worker> workers) {
        workerService.saveAllWorkers(workers);
    }
}
