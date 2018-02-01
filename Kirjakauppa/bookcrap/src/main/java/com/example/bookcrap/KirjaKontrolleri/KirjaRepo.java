package com.example.bookcrap.KirjaKontrolleri;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KirjaRepo extends CrudRepository<Kirja, Long> {
    List<Kirja> findByAuthor(String author);
    List<Kirja> findByTitle(String title);
    List<Kirja> findByIsbn(String isbn);
}
