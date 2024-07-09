package com.thc.realspr.mapper;

import com.thc.realspr.dto.TbuserDto;

import java.util.List;

public interface TbuserMapper {
	TbuserDto.SelectResDto detail(String id);
	List<TbuserDto.SelectResDto> list(TbuserDto.ListReqDto param);
}