package com.easyblog.main.repository;

import com.easyblog.main.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Integer>, ArticlesCustomRepository {
}
