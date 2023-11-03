package com.easyblog.main.repository;

import com.easyblog.main.model.UserProfile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserProfileRepository extends ElasticsearchRepository<UserProfile,Integer> {
}
