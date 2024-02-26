package com.spring.springbootpr.Service;

import com.spring.springbootpr.DTO.CategoryDTO;
import com.spring.springbootpr.DTO.MenuDTO;
import com.spring.springbootpr.Entity.Category;
import com.spring.springbootpr.Entity.Food;
import com.spring.springbootpr.Repository.CateRepository;
import com.spring.springbootpr.Service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    CateRepository cateRepository;

    @Override
    public List<CategoryDTO> getCateHomePage() {

        PageRequest pageRequest = PageRequest.of(0,4, Sort.by("id"));
        Page<Category> categoryList = cateRepository.findAll(pageRequest);
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for (Category cate: categoryList) {
            CategoryDTO categoryDTO = new CategoryDTO();

            categoryDTO.setNameCate(cate.getNameCate());

            List<MenuDTO> menuDTOList = new ArrayList<>();
            for (Food data: cate.getFoodList()) {
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setTitle(data.getTitle());
                menuDTO.setImage(data.getImage());
                menuDTO.setFreeShip(data.isFreeship());

                menuDTOList.add(menuDTO);
            }
            categoryDTO.setMenuDTOList(menuDTOList);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }
}
