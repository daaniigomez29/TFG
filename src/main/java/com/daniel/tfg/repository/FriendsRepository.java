package com.daniel.tfg.repository;

import com.daniel.tfg.model.FriendsModel;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.FriendsModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<FriendsModel, Integer> {

    @Query("SELECT f FROM FriendsModel f WHERE f.user1 = :user")
    List<FriendsModel> findAllFriendsOfUser(@Param("user") UserModel userModel);
}
