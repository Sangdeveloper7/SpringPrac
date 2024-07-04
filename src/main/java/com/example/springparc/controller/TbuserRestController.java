package com.example.springparc.controller;



import com.example.springparc.dto.TbuserDto;
import com.example.springparc.service.TbuserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/tbuser")
@RestController
public class TbuserRestController {

    private final TbuserService tbuserService;
    public TbuserRestController(
            TbuserService tbuserService
    ) {
        this.tbuserService = tbuserService;
    }
    /*
    @PostMapping("")
    public Map<String, Object> create(@RequestBody Map<String, Object> param){
        System.out.println(param);
        return tbuserService.create(param);
    }
    @GetMapping("/get/{id}")
    public Map<String, Object> detail(@PathVariable("id") String id){
        System.out.println(id);
        return tbuserService.get(id);
    }
    @PutMapping("")
    public Map<String, Object> update(@RequestBody Map<String, Object> param){
        System.out.println(param);
        return tbuserService.update(param);
    }
    */
    @PostMapping("")
    public ResponseEntity<TbuserDto.CreateResDto> create(@RequestBody TbuserDto.CreateReqDto param){
        System.out.println("param : " + param);
        return ResponseEntity.status(HttpStatus.CREATED).body(tbuserService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<TbuserDto.CreateResDto> update(@RequestBody TbuserDto.UpdateReqDto param){
        System.out.println(param);
        return ResponseEntity.status(HttpStatus.OK).body(tbuserService.update(param));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<TbuserDto.SelectResDto> detail(@PathVariable("id") String id){
        System.out.println(id);
        return ResponseEntity.status(HttpStatus.OK).body(tbuserService.get(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<TbuserDto.SelectResDto>> list(@Valid TbuserDto.ListReqDto param){
        return ResponseEntity.status(HttpStatus.OK).body(tbuserService.list(param));
    }
}
