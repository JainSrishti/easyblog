package com.easyblog.main.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileDao {

    private Integer id;
    private String name;
    private Date created;
    private Date updated;
    private List<String> interest;
    private String password;
    private String emailid;

}
