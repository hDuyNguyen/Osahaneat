package com.spring.springbootpr.Controller;

import com.spring.springbootpr.Payload.ResponseData;
import com.spring.springbootpr.Service.imp.FileServiceImp;
import com.spring.springbootpr.Service.imp.ResServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin("*")
@RestController
@RequestMapping("/restaurant")
public class ResController {

    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    ResServiceImp resServiceImp;
    @PostMapping()
    public ResponseEntity<?> createRes(@RequestParam MultipartFile file,
                                       @RequestParam String title,
                                       @RequestParam String subtitle,
                                       @RequestParam String description,
                                       @RequestParam boolean is_freeship,
                                       @RequestParam String address,
                                       @RequestParam String open_date) {

        ResponseData responseData = new ResponseData();
        boolean isSuccess = resServiceImp.insertRes(file, title, subtitle, description, is_freeship, address, open_date);
        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getHomeRestaurant() {
        ResponseData responseData = new ResponseData();
        responseData.setData(resServiceImp.getHomePageRes());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename) {
        Resource file = fileServiceImp.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getDetailRes(@RequestParam int id) {
        ResponseData responseData = new ResponseData();
        responseData.setData(resServiceImp.getDetailRes(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
