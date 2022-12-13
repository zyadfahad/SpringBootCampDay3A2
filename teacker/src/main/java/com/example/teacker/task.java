package com.example.teacker;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class task {
    private int ID;
    private String title;
    private String description;
    private String status;
    private String deadline;
}
