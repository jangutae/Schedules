package com.example.schedule.service;

import com.example.schedule.dto.schedule.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    // scheduleRepository 로 일정 저장 요청
    public ScheduleResponseDto save(String title, String contents, String username) {

        Schedule schedule = new Schedule(title, contents, username);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(),
                                        schedule.getContents(), schedule.getUsername());

    }

    // scheduleRepository 로 전체 일정 조회 요청
    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::toDto).toList();


    }

    // scheduleRepository 로 특정 일정 조회 요청
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getContents(), findSchedule.getUsername());
    }

    // scheduleRepository 로 일정 수정 요청
    public ScheduleResponseDto updateSchedule(Long id, String title, String contents) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        Schedule updateSchedule = new Schedule(title, contents);

        return new ScheduleResponseDto(findSchedule.getId(), updateSchedule.getTitle(), updateSchedule.getContents(), findSchedule.getUsername());
    }

    // scheduleRepository 로 일정 부분 수정 요청
    public ScheduleResponseDto updateTitle(Long id, String title) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        Schedule updateTitle = new Schedule(title);

        return new ScheduleResponseDto(findSchedule.getId(), updateTitle.getTitle(), findSchedule.getUsername(), findSchedule.getContents());
    }

    // scheduleRepository 로 일정  요청
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
