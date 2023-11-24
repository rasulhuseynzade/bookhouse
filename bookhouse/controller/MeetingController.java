package com.example.bookhouse.controller;

import com.example.bookhouse.model.MeetingViewDto;
import com.example.bookhouse.service.MeetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book_house/meetings")
@RequiredArgsConstructor
public class MeetingController {
    private final MeetingService meetingService;
    @GetMapping
    public List<MeetingViewDto> getMeetingList(){
        return meetingService.getMeetingList();

    }
    @PostMapping
    public void addMeeting(@RequestBody @Valid MeetingViewDto meetingViewDto){

        meetingService.addMeeting(meetingViewDto);

    }
    @PatchMapping("/{meetingId}")
    public void updateMeeting(
            @PathVariable Long meetingId,
            @RequestBody MeetingViewDto meetingViewDto
    ){
        meetingService.updateMeeting(meetingId, meetingViewDto);

    }
    @DeleteMapping("/{meetingId}")
    public void deleteMeeting(@PathVariable Long meetingId){

        meetingService.deleteMeeting(meetingId);

    }
}
