package com.example.bookhouse.mapper;

import com.example.bookhouse.dao.MeetingEntity;
import com.example.bookhouse.model.MeetingViewDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeetingMapper {

    MeetingViewDto entityToDto(MeetingEntity meetingEntity);
    MeetingEntity dtoToEntity(MeetingViewDto meetingViewDto);

    MeetingEntity dtoToEntity(Long id, MeetingViewDto meetingViewDto);
}
