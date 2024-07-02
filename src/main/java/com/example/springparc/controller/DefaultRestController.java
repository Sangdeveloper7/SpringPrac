package com.example.springparc.controller;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/api/default")
@RestController
public class DefaultRestController {
    @Operation(summary = "파일업로드",
            description = "파일을 서버에 업로드(일반) \n"
                    + "@param MultipartFile multipartFile \n"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<String\\> \n"
                    + "@exception \n"
    )
    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@Valid @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String returnValue = null;
        try {
            //returnValue = FileUpload.s3(file);
            returnValue = FileUpload.local(file, request);
        } catch (IOException e) {
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
