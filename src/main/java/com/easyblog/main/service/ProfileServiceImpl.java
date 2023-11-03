package com.easyblog.main.service;

import com.easyblog.main.dao.UserProfileDao;
import com.easyblog.main.model.UserProfile;
import com.easyblog.main.repository.UserProfileRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Builder
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private final UserProfileRepository userProfileRepository;
    public UserProfileDao signUp(UserProfileDao profile) {
        UserProfile userProfile = UserProfile.builder()
                .id(profile.getId())
                .name(profile.getName())
                .password(profile.getPassword())
                .emailId(profile.getEmailid())
                .build();
        UserProfile savedProfile = userProfileRepository.save(userProfile);
        if(savedProfile.getId() != null) {
            return UserProfileDao.builder().
                    id(savedProfile.getId())
                    .name(savedProfile.getName()).build();
        }
        return null;
    }

    public Boolean loginProfile(UserProfileDao profile) {
        UserProfile userProfile = UserProfile.builder()
                .id(profile.getId())
                .password(profile.getPassword())
                .build();
       Optional<UserProfile> profileFound =  userProfileRepository.findById(userProfile.getId());
       if(profileFound.isPresent() && profileFound.get().getPassword().equals(profile.getPassword()))
       {
           return true;
       }
       else {
           return  false;
       }
    }
}
