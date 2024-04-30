package com.trainingcenter.backendtrainingcenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalResponseBO {
    private Integer code = 200;
    private String desc = "Success";
    private List<ErrorBO> errorBO = new ArrayList<>();
    private Object data = new Object();
}
