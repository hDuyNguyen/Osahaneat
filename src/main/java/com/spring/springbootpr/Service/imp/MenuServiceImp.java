package com.spring.springbootpr.Service.imp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImp {
    boolean createMenu(MultipartFile file, String title, String time_ship, boolean is_freeship, double price, int cate_id);

}