package com.example.mstestes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableFinRequest {
    private float resistanceComp;
    private float poidPrisme;
    private String consistance;
    private String debutPrise;
    private String finPrise;
    private String observation;
}
