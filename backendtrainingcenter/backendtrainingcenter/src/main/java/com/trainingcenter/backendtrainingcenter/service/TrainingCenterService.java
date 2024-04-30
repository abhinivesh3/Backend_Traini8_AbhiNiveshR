package com.trainingcenter.backendtrainingcenter.service;

import com.trainingcenter.backendtrainingcenter.Enum.Type;
import com.trainingcenter.backendtrainingcenter.model.ErrorBO;
import com.trainingcenter.backendtrainingcenter.model.GlobalResponseBO;
import com.trainingcenter.backendtrainingcenter.model.TrainingCenter;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trainingcenter.backendtrainingcenter.DAO.setData;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TrainingCenterService {
    @Autowired
    setData setData;

    public GlobalResponseBO validateTrainingCenter(TrainingCenter trainingCenter) {
        GlobalResponseBO globalResponseBO = new GlobalResponseBO();

        List<ErrorBO> errorList = new ArrayList<>();
        try{
            // Validate mandatory fields
            if (trainingCenter.getCenterName() == null || trainingCenter.getCenterName().isEmpty()) {
                errorList.add(new ErrorBO(400, "Mandotory field missing", "CenterName", Type.Validation));
            }
            if (trainingCenter.getAddress().getDetailedAddress() == null || trainingCenter.getAddress().getDetailedAddress().isEmpty()) {
                errorList.add(new ErrorBO(400, "Mandotory field missing", "DetailedAddress", Type.Validation));
            }

            if (trainingCenter.getAddress().getCity() == null || trainingCenter.getAddress().getCity().isEmpty()) {
                errorList.add(new ErrorBO(400, "Mandotory field missing", "City", Type.Validation));
            }

            if (trainingCenter.getAddress().getState() == null || trainingCenter.getAddress().getState().isEmpty()) {
                errorList.add(new ErrorBO(400, "Mandotory field missing", "State", Type.Validation));
            }

            //Validate PinCode length and numbers
            if (trainingCenter.getAddress().getPincode() == null || trainingCenter.getAddress().getPincode().length()!=6 || !trainingCenter.getAddress().getPincode().matches("^[0-9]{6}$")) {
                errorList.add(new ErrorBO(400, "Error in Mandatory field", "Pincode", Type.Validation));}

            // Validate CenterCode length and alphanumeric
            if (trainingCenter.getCenterCode() == null || trainingCenter.getCenterCode().length() != 12
                    || !trainingCenter.getCenterCode().matches("[a-zA-Z0-9]+")) {
                errorList.add(new ErrorBO(400, "Mandotory field missing", "CenterName", Type.Validation));
                throw new ValidationException("CenterCode should be exactly 12 characters alphanumeric");
            }

            // Validate email if present
            if (trainingCenter.getContactEmail() != null && !trainingCenter.getContactEmail().isEmpty() ) {
                if(!trainingCenter.getContactEmail().matches("^(.+)@(.+)$")){
                    errorList.add(new ErrorBO(400, "Mandotory field missing", "Email", Type.Validation));
                }
            }
            // Validate mandatory fields
            if (trainingCenter.getContactPhone() == null || trainingCenter.getContactPhone().isEmpty()) {
                errorList.add(new ErrorBO(400, "Mandotory field missing", "ContactPhone", Type.Validation));
            }

            // Validate phone number
            if (trainingCenter.getContactPhone().length() != 10 || !trainingCenter.getContactPhone().matches("^[0-9]{10}$")) {
                errorList.add(new ErrorBO(400, "ContactPhone should be exactly 10 numbers", "ContactPhone", Type.Validation));
            }
        }catch(Exception exception){
            log.error("Exception raised : {}",exception.toString());
        }

        if(errorList.isEmpty()){
            globalResponseBO.setCode(200);
            globalResponseBO.setData(setData.mapToTrainingCenter(trainingCenter));
            globalResponseBO.setDesc("Data is been successfully set!");
            globalResponseBO.setErrorBO(new ArrayList<>());
        }else{
            globalResponseBO.setCode(400);
            globalResponseBO.setData(new Object());
            globalResponseBO.setErrorBO(errorList);
            globalResponseBO.setDesc("Data is invalid!");
        }
        return globalResponseBO;
    }

    public List<TrainingCenter> getTrainingData(){
        List<TrainingCenter> resultData = new ArrayList<>();
        try {
            resultData = setData.getAllTrainingCenter();
        }catch(Exception e){
            log.error(e.toString());
        }
        return resultData;
    }
}
