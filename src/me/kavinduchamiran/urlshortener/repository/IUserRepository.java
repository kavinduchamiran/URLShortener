package me.kavinduchamiran.urlshortener.repository;

import me.kavinduchamiran.urlshortener.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends CrudRepository<User, String>, PagingAndSortingRepository<User, String> {

}
