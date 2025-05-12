package com.ms.user.repositories;

import com.ms.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel,UUID> {

    //passa pro JPA a classe de entidade e o tipo de identificador ID
}
