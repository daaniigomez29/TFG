package com.daniel.tfg.repository;

import com.daniel.tfg.model.RequestFriendModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestFriendRepository extends JpaRepository<RequestFriendModel, Integer> {
}
