package com.example.roombookingserver.model;

import lombok.Getter;

@Getter
public enum Layout {
   THEATER("Theater"),
    USHAPE("U-Shape"),
    BOARD("Board Meeting");

   private String description;

    Layout(String description) {
        this.description = description;
    }


}
