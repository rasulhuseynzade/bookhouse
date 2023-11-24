package com.example.bookhouse.service;

import com.example.bookhouse.mapper.MeetingMapper;
import com.example.bookhouse.model.MeetingViewDto;
import com.example.bookhouse.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final MeetingMapper meetingMapper;

    public List<MeetingViewDto> getMeetingList(){
        var meetingEntity = meetingRepository.findAll();
        return meetingEntity.stream()
                .map(meetingMapper::entityToDto)
                .collect(Collectors.toList());
    }
    public void addMeeting(MeetingViewDto meetingViewDto){
        var meetingEntity = meetingMapper.dtoToEntity(meetingViewDto);
        meetingRepository.save(meetingEntity);
    }
    public void updateMeeting(Long meetingId, MeetingViewDto meetingViewDto){
        var meetingEntity = meetingMapper.dtoToEntity(meetingViewDto);
        meetingRepository.save(meetingEntity);
    }
    public void deleteMeeting(Long meetingId){

        meetingRepository.deleteById(meetingId);
    }
}
