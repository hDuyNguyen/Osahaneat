package com.spring.springbootpr.Controller;

import com.spring.springbootpr.Payload.ResponseData;
import com.spring.springbootpr.Service.imp.FileServiceImp;
import com.spring.springbootpr.Service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuServiceImp menuServiceImp;

    @Autowired
    FileServiceImp fileServiceImp;

    @PostMapping()
    public ResponseEntity<?> createMenu(@RequestParam MultipartFile file,
                                       @RequestParam String title,
                                       @RequestParam String time_ship,
                                       @RequestParam boolean is_freeship,
                                       @RequestParam double price,
                                        @RequestParam int cate_id) {

        ResponseData responseData = new ResponseData();
        boolean isSuccess = menuServiceImp.createMenu(file, title, time_ship, is_freeship, price, cate_id);
        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename) {
        Resource file = fileServiceImp.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
