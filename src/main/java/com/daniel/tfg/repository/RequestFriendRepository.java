package com.daniel.tfg.repository;

import com.daniel.tfg.model.RequestFriendModel;
import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestFriendRepository extends JpaRepository<RequestFriendModel, Integer> {

    @Query("SELECT rf FROM RequestFriendModel WHERE rf.userReceive = :user")
    List<RequestFriendModelDto> findAllRequestsOfUser(@Param("user") UserModelDto userModelDto);
}
