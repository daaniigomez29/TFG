package com.daniel.tfg.repository;

import com.daniel.tfg.model.RequestFriendModel;
import com.daniel.tfg.model.UserModel;
import com.daniel.tfg.model.dto.RequestFriendModelDto;
import com.daniel.tfg.model.dto.UserModelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestFriendRepository extends JpaRepository<RequestFriendModel, Integer> {

    @Query("SELECT rf FROM RequestFriendModel rf WHERE rf.userReceive = :user")
    List<RequestFriendModel> findAllRequestsToUser(@Param("user") UserModel userModel);

    Optional<RequestFriendModel> findByUserRequestIdAndUserReceiveId(Integer userRequestId, Integer userReceiveId);
}
