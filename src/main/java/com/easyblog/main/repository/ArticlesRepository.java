package com.easyblog.main.repository;

import com.easyblog.main.model.Articles;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesRepository extends ElasticsearchRepository<Articles, Integer>, ArticlesCustomRepository {

    List<Articles> findByTitleContaining(String text);
}
