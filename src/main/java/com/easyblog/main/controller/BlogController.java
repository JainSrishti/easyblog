package com.easyblog.main.controller;

import com.easyblog.main.dao.AddArticleResponseDao;
import com.easyblog.main.dao.UserArticleDao;
import com.easyblog.main.dao.UserProfileDao;
import com.easyblog.main.service.ArticleServiceImpl;
import com.easyblog.main.service.ProfileServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Builder
@AllArgsConstructor
@RestController
public class BlogController {

    @Autowired
    private final ProfileServiceImpl profileServiceImpl;
    @Autowired
    private final ArticleServiceImpl articleServiceImpl;

    @GetMapping(value = "/test")
    @ResponseBody
    public String getArticleByUserId() {
        return "Hello Akash Gaikwad!";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    @ResponseBody
    public ResponseEntity<UserProfileDao> createUserProfile(@RequestBody UserProfileDao request){
        UserProfileDao profile = profileServiceImpl.signUp(request);
        return ResponseEntity.ok(profile);
    }

    @PostMapping(value = "/signin")
    @ResponseBody
    public Boolean userLogin(@RequestBody UserProfileDao loginCreds) {
        return  profileServiceImpl.loginProfile(loginCreds);
    }

    @PostMapping(value = "/addarticle")
    @ResponseBody
    public Boolean saveArticle(@RequestBody UserArticleDao articleDao) {
        return articleServiceImpl.addArticle(articleDao);
    }

    @PostMapping(value = "/publisharticle")
    @ResponseBody
    public Boolean publishArticle(@RequestBody UserArticleDao articleDao) {
        return articleServiceImpl.publishArticle(articleDao);
    }

    @GetMapping(value = "/get_saved_articles")
    @ResponseBody
    public AddArticleResponseDao getArticleByUserId(@RequestParam Integer userid) {
        return articleServiceImpl.getSavedArticle(userid);
    }

    @GetMapping(value = "/get_published_articles")
    @ResponseBody
    public AddArticleResponseDao getPublishedArticlesForUser(@RequestParam Integer userid) {
        return articleServiceImpl.getPublishedArticle(userid);
    }
    @GetMapping(value = "/recommended")
    @ResponseBody
    public AddArticleResponseDao getRecommendedArticle(@RequestParam Integer userid) {
        return articleServiceImpl.getRecommendedArticle(userid);
    }

    // from all the published artciles, just put the logic of reutnring back by sorting on the most likesd
  /*  @GetMapping(value = "/trending")
    @ResponseBody
    public AddArticleResponseDao getTrendingArticles() {
       // return articleServiceImpl.getSavedArticle(userid);
    }*/
}
