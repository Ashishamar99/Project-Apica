package com.apico.usermanangement.dao;

import com.apico.usermanangement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManagementRepository extends JpaRepository<User, String> {
}
