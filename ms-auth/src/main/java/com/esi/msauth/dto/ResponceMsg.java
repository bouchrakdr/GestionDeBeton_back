package com.esi.msauth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponceMsg {
    Long id;
    String Msg;

    public ResponceMsg(String msg){
        this.Msg=msg;
    }
}
