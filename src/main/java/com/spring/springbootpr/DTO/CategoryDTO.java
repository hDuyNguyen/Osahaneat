package com.spring.springbootpr.DTO;

import java.util.List;

public class CategoryDTO {
    private String nameCate;
    private List<MenuDTO> menuDTOList;

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public List<MenuDTO> getMenuDTOList() {
        return menuDTOList;
    }

    public void setMenuDTOList(List<MenuDTO> menuDTOList) {
        this.menuDTOList = menuDTOList;
    }
}
