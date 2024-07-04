package com.thc.realspr.mapper;

import com.thc.realspr.dto.TbuserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbuserMapper {

    TbuserDto.SelectResDto detail(String id);
    List<TbuserDto.SelectResDto> list(TbuserDto.ListReqDto param);
}
