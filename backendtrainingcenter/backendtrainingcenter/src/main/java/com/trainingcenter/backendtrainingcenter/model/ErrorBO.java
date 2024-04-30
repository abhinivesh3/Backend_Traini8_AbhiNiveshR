package com.trainingcenter.backendtrainingcenter.model;

import com.trainingcenter.backendtrainingcenter.Enum.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorBO {
    private int statusCode=200;
    private String description;
    private String field;
    private Type type;
}
