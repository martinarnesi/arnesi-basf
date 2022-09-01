package com.basf.rest;

import com.basf.dto.PatentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("v1/patent")
@Slf4j
public class PatentController {

    //TOOD (a) upload an archive to the service and run extraction pipeline
    //TODO (b) delete the whole database (just for making it easy to test the code)

    @GetMapping("/list/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PatentDTO> getListOfPatents() {
        // Call processing service

        PatentDTO patentDto = new PatentDTO();
        patentDto.setIdentifier("1234");
        patentDto.setYear("1978");
        patentDto.setTitle("Isobutanol Component");
        patentDto.setAbstractData("Some Abstract Data");

        return List.of(patentDto);
    }

    @DeleteMapping("/delete/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlLPatents() {
        // Call Processor service
    }

    @PostMapping(path="/upload/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFiles(@RequestParam("multipleFiles") MultipartFile[] files) throws Exception {

        if (Objects.isNull(files) || files.length == 0) {
            throw new RuntimeException("Please select at least one file for uploading");
        }

        StringBuilder sb = new StringBuilder(files.length);

        for (int i = 0; i < files.length; i++) {
            InputStream inputStream = files[i].getInputStream();
            String originalName = files[i].getOriginalFilename();
            String name = files[i].getName();
            String contentType = files[i].getContentType();
            long size = files[i].getSize();

            sb.append("File Name: " + originalName + "\n");

            log.info("InputStream: " + inputStream);
            log.info("OriginalName: " + originalName);
            log.info("Name: " + name);
            log.info("ContentType: " + contentType);
            log.info("Size: " + size);
        }

        // Call processing service with uploaded file data in Service layer


        return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
    }
}
