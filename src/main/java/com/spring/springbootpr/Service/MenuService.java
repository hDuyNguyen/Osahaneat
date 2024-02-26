package com.spring.springbootpr.Service;

import com.spring.springbootpr.Entity.Category;
import com.spring.springbootpr.Entity.Food;
import com.spring.springbootpr.Entity.Restaurant;
import com.spring.springbootpr.Repository.FoodRepository;
import com.spring.springbootpr.Service.imp.FileServiceImp;
import com.spring.springbootpr.Service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MenuService implements MenuServiceImp {

    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    FoodRepository foodRepository;
    @Override
    public boolean createMenu(MultipartFile file, String title, String time_ship, boolean is_freeship, double price, int cate_id) {
        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess) {
                Food food = new Food();

                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setTimeShip(time_ship);
                food.setFreeship(is_freeship);
                food.setPrice(price);

                Category category = new Category();
                category.setId(cate_id);
                food.setCategory(category);

                foodRepository.save(food);

                isInsertSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Error insert " + e.getMessage());
        }

        return isInsertSuccess;
    }
}
