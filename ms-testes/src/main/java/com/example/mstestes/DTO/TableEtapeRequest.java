package com.example.mstestes.DTO;

import com.example.mstestes.entities.TableEtape;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableEtapeRequest {
    private String dateE;
    private float resistanceF;
    private float rune;
    private float rde;
    private TableEtape.Etape etape;
}
