package com.easyblog.main.repository;

import com.easyblog.main.model.Articles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ArticlesCustomRepositoryImpl implements ArticlesCustomRepository{

    private final EntityManager entityManager;
    @Override
    public List<Articles> findByUserId(Integer userid) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Articles> articles = criteriaQuery.from(Articles.class);

        Predicate userIdPredicate = criteriaBuilder.equal(articles.get("userid"), userid);
        Predicate isPublishedPredicate = criteriaBuilder.equal(articles.get("isPublished"), false);
        Predicate finalPredicate
                = criteriaBuilder.and(userIdPredicate, isPublishedPredicate);
        criteriaQuery.where(finalPredicate);
        TypedQuery<Articles> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();

    }

    @Override
    public List<Articles> findByUserIdPublished(Integer userid) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Articles> articles = criteriaQuery.from(Articles.class);

        Predicate userIdPredicate = criteriaBuilder.equal(articles.get("userid"), userid);
        Predicate isPublishedPredicate = criteriaBuilder.equal(articles.get("isPublished"), true);
        Predicate finalPredicate
                = criteriaBuilder.and(userIdPredicate, isPublishedPredicate);
        criteriaQuery.where(finalPredicate);
        TypedQuery<Articles> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void updateArticlePublished(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // create update
        CriteriaUpdate<Articles> update = cb.createCriteriaUpdate(Articles.class);

        // set the root class
        Root<Articles> e = update.from(Articles.class);

        // set update and where clause
        update.set("isPublished", true);
        update.where(cb.equal(e.get("id"), id));

        // perform update
        entityManager.createQuery(update).executeUpdate();
    }
}
