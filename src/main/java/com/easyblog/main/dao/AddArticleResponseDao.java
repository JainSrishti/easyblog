package com.easyblog.main.dao;

import com.easyblog.main.model.Articles;
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
public class AddArticleResponseDao {

    private UserProfileDao profileDao;
   private List<Articles> articlesList;

}
