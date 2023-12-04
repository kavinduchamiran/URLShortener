package me.kavinduchamiran.urlshortener.repository;

import me.kavinduchamiran.urlshortener.entities.URL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IURLRepository extends CrudRepository<URL, String>, PagingAndSortingRepository<URL, String> {
}
