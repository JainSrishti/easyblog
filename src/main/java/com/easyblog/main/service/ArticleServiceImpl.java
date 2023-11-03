package com.easyblog.main.service;

import com.easyblog.main.dao.AddArticleResponseDao;
import com.easyblog.main.dao.UserArticleDao;
import com.easyblog.main.dao.UserProfileDao;
import com.easyblog.main.model.Articles;
import com.easyblog.main.model.UserProfile;
import com.easyblog.main.repository.ArticlesRepository;
import com.easyblog.main.repository.UserProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticlesRepository articlesRepository;
    private final UserProfileRepository userProfileRepository;

    @Override
    public Boolean addArticle(UserArticleDao articleDao) {
        Articles article = Articles.builder()
                .title(articleDao.getTitle())
                .likesCount(articleDao.getLikesCount())
                .content(articleDao.getContent())
                .isPublished(false)
                .userid(articleDao.getProfile().getId())
                .build();
        Articles savedArticle = articlesRepository.save(article);
        if (savedArticle.getId() != null) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean publishArticle(UserArticleDao articleDao) {

        if (articleDao.getArticleId() != null) {
            Optional<Articles> article = articlesRepository.findById(articleDao.getArticleId());
            if (article.isPresent()) {
            article.get().setIsPublished(true);
            articlesRepository.updateArticlePublished(article.get().getId());
            return true;
            //update
            }
    }
        else {
            Articles articleNew = Articles.builder()
                    .title(articleDao.getTitle())
                    .likesCount(articleDao.getLikesCount())
                    .content(articleDao.getContent())
                    .userid(articleDao.getProfile().getId())
                    .isPublished(true)
                    .build();
            Articles savedArticle = articlesRepository.save(articleNew);
            if (savedArticle.getId() != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AddArticleResponseDao getSavedArticle(Integer userid) {
        List<Articles> articles = articlesRepository.findByUserId(userid);
        return AddArticleResponseDao.builder()
                .articlesList(articles)
                .profileDao(UserProfileDao.builder()
                        .id(articles.get(0).getUserid())
                        .build())
                        .build();
    }

    @Override
    public AddArticleResponseDao getPublishedArticle(Integer userid) {
        List<Articles> articles = articlesRepository.findByUserIdPublished(userid);
        return AddArticleResponseDao.builder()
                .articlesList(articles)
                .profileDao(UserProfileDao.builder()
                        .id(articles.get(0).getUserid())
                        .build())
                        .build();
    }

    @Override
    public AddArticleResponseDao getRecommendedArticle(Integer userid) {
        Optional<UserProfile> profile = userProfileRepository.findById(userid);
        if(profile.isPresent()) {
                List<String> userInterests = profile.get().getInterests();
                List<Articles> articles = articlesRepository.findByTitleContaining("Java");
                //logic of filter interest articles;
                //articles.stream().filter(article -> article.getContent().contains(userInterests.stream().)).collect(Collectors.toList())
           return AddArticleResponseDao.
                    builder()
                    .articlesList(articles)
                    .build();
        }
        return AddArticleResponseDao.
                builder()
                .build();

    }
}
