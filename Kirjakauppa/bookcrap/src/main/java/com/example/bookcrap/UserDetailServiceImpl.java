package com.example.bookcrap;

import com.example.bookcrap.KirjaKontrolleri.User;
import com.example.bookcrap.KirjaKontrolleri.UserCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserCrudRepo repo;

    @Autowired
    public UserDetailServiceImpl(UserCrudRepo userRepository) {
        this.repo = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User curruser = repo.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }
}
