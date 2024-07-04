package com.thc.realspr.controller;


import com.thc.realspr.dto.CommonDto;
import com.thc.realspr.dto.TbpostDto;
import com.thc.realspr.service.TbpostService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tbpost")
@RestController
public class TbpostRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TbpostService tbpostService;
    public TbpostRestController(
            TbpostService tbpostservice
    ){
        this.tbpostService = tbpostservice;
    }

    @PostMapping("")
    public ResponseEntity<TbpostDto.CreateResDto> create(@RequestBody TbpostDto.CreateReqDto param){
        System.out.println("param : " + param);
        return ResponseEntity.status(HttpStatus.CREATED).body(tbpostService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<TbpostDto.CreateResDto> update(@RequestBody TbpostDto.UpdateReqDto param){
        System.out.println(param);
        return ResponseEntity.status(HttpStatus.OK).body(tbpostService.update(param));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<TbpostDto.SelectResDto> detail(@PathVariable("id") String id){
        System.out.println(id);
        return ResponseEntity.status(HttpStatus.OK).body(tbpostService.get(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<TbpostDto.SelectResDto>> list(@Valid TbpostDto.ListReqDto param){
        return ResponseEntity.status(HttpStatus.OK).body(tbpostService.list(param));
    }

    @GetMapping("/mlist")
    public ResponseEntity<List<TbpostDto.SelectResDto>> mlist(@Valid TbpostDto.MoreListReqDto param){
        logger.info("mlist : " + param);
        return ResponseEntity.status(HttpStatus.OK).body(tbpostService.moreList(param));
    }
    @GetMapping("/plist")
    public ResponseEntity<CommonDto.PagedListResDto> plist(@Valid TbpostDto.PagedListReqDto param){
        logger.info("plist : " + param);
        return ResponseEntity.status(HttpStatus.OK).body(tbpostService.pagedlist(param));
    }

}
