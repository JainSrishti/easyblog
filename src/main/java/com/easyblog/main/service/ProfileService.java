package com.easyblog.main.service;

import com.easyblog.main.dao.UserProfileDao;

public interface ProfileService {

    public UserProfileDao signUp(UserProfileDao profile);
    public Boolean loginProfile(UserProfileDao profile);
}
