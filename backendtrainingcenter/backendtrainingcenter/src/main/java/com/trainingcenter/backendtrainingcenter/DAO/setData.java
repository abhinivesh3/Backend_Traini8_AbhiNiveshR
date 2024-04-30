package com.trainingcenter.backendtrainingcenter.DAO;

import com.trainingcenter.backendtrainingcenter.model.TrainingCenter;
import com.trainingcenter.backendtrainingcenter.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class setData {
    @Autowired
    TrainingCenterRepository trainingCenterRepository;

    public TrainingCenter mapToTrainingCenter(TrainingCenter trainingCenterDto) {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName(trainingCenterDto.getCenterName());
        trainingCenter.setCenterCode(trainingCenterDto.getCenterCode());
        trainingCenter.setAddress(trainingCenterDto.getAddress());
        trainingCenter.setStudentCapacity(trainingCenterDto.getStudentCapacity());
        trainingCenter.setCoursesOffered(trainingCenterDto.getCoursesOffered());
        trainingCenter.setCreatedOn(currentDateTime());
        trainingCenter.setContactEmail(trainingCenterDto.getContactEmail());
        trainingCenter.setContactPhone(trainingCenterDto.getContactPhone());
        trainingCenterRepository.save(trainingCenter);
        return trainingCenter;
    }

    public String currentDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }

    public List<TrainingCenter> getAllTrainingCenter() {
        // Find All TrainingCenter from the database
        return trainingCenterRepository.findAll();
    }

}
