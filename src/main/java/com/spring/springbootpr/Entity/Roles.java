package com.spring.springbootpr.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "roles")
    private List<Users> usersList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }
}
