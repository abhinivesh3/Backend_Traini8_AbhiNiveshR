package com.trainingcenter.backendtrainingcenter.controller;

import com.trainingcenter.backendtrainingcenter.model.GlobalResponseBO;
import com.trainingcenter.backendtrainingcenter.model.TrainingCenter;
import com.trainingcenter.backendtrainingcenter.service.TrainingCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/training-center")
public class TrainingCenterController {
    @Autowired
    TrainingCenterService trainingCenterService;

    // Get Api
    @GetMapping("/getAll")
    public List<TrainingCenter> getAllTrainingCenter() {
        List<TrainingCenter> resultList = new ArrayList<>();
        try {
            resultList = trainingCenterService.getTrainingData();
        } catch (Exception e) {
            log.error("Error occured in controller : {}", e.toString());
        }
        return resultList;
    }

    //Post Api
    @PostMapping("/create")
    public GlobalResponseBO createTrainingCenter(@RequestBody TrainingCenter trainingCenter) {
        GlobalResponseBO globalResponseBO = new GlobalResponseBO();
        try {
            globalResponseBO = trainingCenterService.validateTrainingCenter(trainingCenter);
        } catch (Exception e) {
            log.error("Error occured in controller : {}", e.toString());
        }
        return globalResponseBO;
    }

}
