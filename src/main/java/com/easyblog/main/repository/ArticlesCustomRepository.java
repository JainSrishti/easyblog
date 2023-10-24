package com.easyblog.main.repository;

import com.easyblog.main.model.Articles;

import java.util.List;

public interface ArticlesCustomRepository {
    public List<Articles> findByUserId(Integer userid);
    public List<Articles> findByUserIdPublished(Integer userid);
    public void updateArticlePublished(Integer articleid);
}
