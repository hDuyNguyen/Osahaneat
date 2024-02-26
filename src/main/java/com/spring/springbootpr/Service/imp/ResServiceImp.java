package com.spring.springbootpr.Service.imp;

import com.spring.springbootpr.DTO.ResDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface ResServiceImp {
    boolean insertRes(MultipartFile file,
                      String title,
                      String subtitle,
                      String description,
                      boolean is_freeship,
                      String address,
                      String open_date);

    List<ResDTO> getHomePageRes();
    ResDTO getDetailRes(int id);
}
