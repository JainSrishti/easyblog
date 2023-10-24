package com.easyblog.main.service;

import com.easyblog.main.dao.AddArticleResponseDao;
import com.easyblog.main.dao.UserArticleDao;

import java.util.List;

public interface ArticleService {

    public Boolean addArticle(UserArticleDao articleDao);
    public Boolean publishArticle(UserArticleDao articleDao);

    public AddArticleResponseDao getSavedArticle(Integer userid);
    public AddArticleResponseDao getPublishedArticle(Integer userid);

    public AddArticleResponseDao getRecommendedArticle(Integer userid);
}
