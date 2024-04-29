package com.heejun.repository;

import com.heejun.domain.Email;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface EmailRepository {

    int save(Email email);

    Optional<Email> findByEmail(String email);

    List<Email> findAll();

    int update(Email email);

    int deleteByEmail(String email);
}
