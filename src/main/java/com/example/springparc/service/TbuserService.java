package com.example.springparc.service;

import com.example.springparc.dto.TbuserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbuserService {
    /*
    public Map<String, Object> create(Map<String, Object> param);
    public Map<String, Object> get(String id);
    public Map<String, Object> update(Map<String, Object> param);
    */
    public TbuserDto.CreateResDto create(TbuserDto.CreateReqDto param);
    public TbuserDto.CreateResDto update(TbuserDto.UpdateReqDto param);
    public TbuserDto.SelectResDto get(String id);
    public List<TbuserDto.SelectResDto> list(TbuserDto.ListReqDto param);
}
