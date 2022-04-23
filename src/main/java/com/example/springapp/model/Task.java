package com.example.springapp.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
public class Task {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String time;

    @Getter
    @Setter
    private String icon;

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}

