package com.thc.realspr.mapper;

import com.thc.realspr.dto.TbpostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbpostMapper {
    TbpostDto.SelectResDto detail(String id);
    List<TbpostDto.SelectResDto> list(TbpostDto.ListReqDto param);

    List<TbpostDto.SelectResDto> moreList(TbpostDto.MoreListReqDto param);
    List<TbpostDto.SelectResDto> pagedList(TbpostDto.PagedListServDto param);
    int pagedListCount(TbpostDto.PagedListReqDto param);
}