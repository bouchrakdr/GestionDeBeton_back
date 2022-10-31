package com.example.mstestes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableDebutRequest {
    private String dateTest;
    private float temperature;

}
