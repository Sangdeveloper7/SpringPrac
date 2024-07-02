package com.example.springparc.service;

import com.example.springparc.dto.CommonDto;
import com.example.springparc.dto.TbpostDto;
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
