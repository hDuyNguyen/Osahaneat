package com.spring.springbootpr.Service;

import com.spring.springbootpr.DTO.CategoryDTO;
import com.spring.springbootpr.DTO.MenuDTO;
import com.spring.springbootpr.DTO.ResDTO;
import com.spring.springbootpr.Entity.Food;
import com.spring.springbootpr.Entity.MenuRestaurant;
import com.spring.springbootpr.Entity.RatingRestaurant;
import com.spring.springbootpr.Entity.Restaurant;
import com.spring.springbootpr.Repository.ResRepository;
import com.spring.springbootpr.Service.imp.FileServiceImp;
import com.spring.springbootpr.Service.imp.ResServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ResService implements ResServiceImp {

    @Autowired
    ResRepository resRepository;

    @Autowired
    FileServiceImp fileServiceImp;
    @Override
    public boolean insertRes(MultipartFile file, String title, String subtitle, String description,
                             boolean is_freeship, String address, String open_date) {

        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess) {
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDescription(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setIs_freeship(is_freeship);
                restaurant.setAddress(address);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                Date openDate = simpleDateFormat.parse(open_date);
                restaurant.setOpenDate(openDate);

                resRepository.save(restaurant);
                isInsertSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Error insert " + e.getMessage());
        }

        return isInsertSuccess;
    }

    @Override
    public List<ResDTO> getHomePageRes() {

        List<ResDTO> resDTOList = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0,6);
        Page<Restaurant> listData = resRepository.findAll(pageRequest);

        for (Restaurant res: listData) {
            ResDTO resDTO = new ResDTO();

            resDTO.setId(res.getId());
            resDTO.setImage(res.getImage());
            resDTO.setSubtitle(res.getSubtitle());
            resDTO.setTitle(res.getTitle());
            resDTO.setFreeship(res.isIs_freeship());
            resDTO.setRating(calculatorRating(res.getRatingRestaurantList()));
            resDTO.setDescription(res.getDescription());

            resDTOList.add(resDTO);
        }

        return resDTOList;
    }

    @Override
    public ResDTO getDetailRes(int id) {
        Optional<Restaurant> restaurant = resRepository.findById(id);
        ResDTO resDTO = new ResDTO();
        if (restaurant.isPresent()) {

            List<CategoryDTO> categoryDTOList = new ArrayList<>();
            Restaurant data = restaurant.get();

            resDTO.setTitle(data.getTitle());
            resDTO.setImage(data.getImage());
            resDTO.setSubtitle(data.getSubtitle());
            resDTO.setAddress(data.getAddress());
            resDTO.setFreeship(data.isIs_freeship());
            resDTO.setDescription(data.getDescription());
            resDTO.setRating(calculatorRating(data.getRatingRestaurantList()));
            resDTO.setOpenDate(data.getOpenDate());

            for (MenuRestaurant menuRestaurant: data.getMenuRestaurantList()) {
                CategoryDTO categoryDTO = new CategoryDTO();
                List<MenuDTO> menuDTOList = new ArrayList<>();

                categoryDTO.setNameCate(menuRestaurant.getCategory().getNameCate());

                for (Food food: menuRestaurant.getCategory().getFoodList()) {
                    MenuDTO menuDTO = new MenuDTO();

                    menuDTO.setId(food.getId());
                    menuDTO.setTitle(food.getTitle());
                    menuDTO.setImage(food.getImage());
                    menuDTO.setFreeShip(food.isFreeship());
                    menuDTO.setTimeShip(food.getTimeShip());
                    menuDTO.setDescription(food.getDescription());
                    menuDTO.setPrice(food.getPrice());

                    menuDTOList.add(menuDTO);
                }

                categoryDTO.setMenuDTOList(menuDTOList);
                categoryDTOList.add(categoryDTO);
            }
            resDTO.setCategoryList(categoryDTOList);
        }
        return resDTO;
    }

    private double calculatorRating(List<RatingRestaurant> listRating) {
        double totalPoint = 0;

        for (RatingRestaurant data: listRating) {
            totalPoint += data.getRatePoint();
        }

        return totalPoint/listRating.size();
    }
}
