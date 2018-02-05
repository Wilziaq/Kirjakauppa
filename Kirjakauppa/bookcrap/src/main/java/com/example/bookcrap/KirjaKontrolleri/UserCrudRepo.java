package com.example.bookcrap.KirjaKontrolleri;

import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
