package com.example.schedule.dto.schedule;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final  String contents;

    private  String username;

    public ScheduleResponseDto(Long id, String title, String contents, String username) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents(), schedule.getUsername());
    }
}
