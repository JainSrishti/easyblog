package com.easyblog.main.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserArticleDao {

    private Integer articleId;
    private UserProfileDao profile;
    private String title;
    private String content;
    private Integer likesCount;

}
