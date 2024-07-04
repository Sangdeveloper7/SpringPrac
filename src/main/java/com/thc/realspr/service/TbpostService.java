package com.thc.realspr.service;

import com.thc.realspr.dto.CommonDto;
import com.thc.realspr.dto.TbpostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbpostService {
    public TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param);
    public TbpostDto.CreateResDto update(TbpostDto.UpdateReqDto param);
    public TbpostDto.SelectResDto get(String id);
    public List<TbpostDto.SelectResDto> list(TbpostDto.ListReqDto param);
    public List<TbpostDto.SelectResDto> moreList(TbpostDto.MoreListReqDto param);
    public CommonDto.PagedListResDto<TbpostDto.SelectResDto> pagedlist(TbpostDto.PagedListReqDto param);
}
