package com.heejun.repository;

import com.heejun.domain.Email;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface EmailRepository {

    int save(Connection connection, Email email);

    Optional<Email> findByEmail(Connection connection, String email);

    List<Email> findAll(Connection connection);

    int update(Connection connection, Email email);

    int deleteByEmail(Connection connection, String email);
}
