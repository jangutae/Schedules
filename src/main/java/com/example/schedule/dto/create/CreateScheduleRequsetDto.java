package com.example.schedule.dto.create;

import lombok.Getter;

@Getter
public class CreateScheduleRequsetDto {

    private final String title;

    private final String contents;

    private final String username;

    public CreateScheduleRequsetDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}
