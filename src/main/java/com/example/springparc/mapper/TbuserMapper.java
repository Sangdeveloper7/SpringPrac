package com.example.springparc.mapper;

import com.example.springparc.dto.TbuserDto;

import java.util.List;

public interface TbuserMapper {

    TbuserDto.SelectResDto detail(String id);
    List<TbuserDto.SelectResDto> list(TbuserDto.ListReqDto param);
}
