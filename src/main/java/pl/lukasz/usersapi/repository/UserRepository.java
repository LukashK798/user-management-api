package pl.lukasz.usersapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukasz.usersapi.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long>{}
