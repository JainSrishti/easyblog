package com.easyblog.main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.List;


@Document(indexName = "UserProfile")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    @Id
    private Integer id;

    private String name;

    private String emailId;

    private String password;

    private Date createdAt;

    private Date updatedAt;

    private List<String> interests;


}
