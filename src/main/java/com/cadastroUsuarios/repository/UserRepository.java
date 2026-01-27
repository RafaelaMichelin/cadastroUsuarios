package com.cadastroUsuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastroUsuarios.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
