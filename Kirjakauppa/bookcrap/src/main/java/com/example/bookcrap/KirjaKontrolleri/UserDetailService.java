package com.example.bookcrap.KirjaKontrolleri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
    private final UserCrudRepo repo;
    @Autowired
    public UserDetailServiceImpl (UserCrudRepo repos){
        this.repo = repos;
    }
    @Override
    public UserDetails loadUserByName(String username) throws UsernameNotFoundException{
        User currentUser = repo.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword(), AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
}
