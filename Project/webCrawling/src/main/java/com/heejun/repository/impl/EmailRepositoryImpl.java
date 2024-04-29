package com.heejun.repository.impl;

import com.heejun.domain.Email;
import com.heejun.repository.EmailRepository;
import com.heejun.util.DbUtils;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class EmailRepositoryImpl implements EmailRepository {

    @Override
    public int save(Email email) {

        String sql = "insert into web_crawling_email (name, email, created_at) values (?, ?, ?)";

        try (Connection connection = DbUtils.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email.getName());
            preparedStatement.setString(2, email.getEmail());
            preparedStatement.setString(3, email.getCreatedAt().toString());

            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Email> findByEmail(String email) {

        String sql = "select name, email, created_at from web_crawling_email where email = ?";

        try (Connection connection = DbUtils.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Email(
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getTimestamp("created_at").toLocalDateTime())
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Email> findAll() {

        List<Email> emails = new ArrayList<>();
        String sql = "select name, email, created_at from web_crawling_email";

        try (Connection connection = DbUtils.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    emails.add(new Email(
                       resultSet.getString("name"),
                       resultSet.getString("email"),
                       resultSet.getTimestamp("created_at").toLocalDateTime()
                    ));
                }
            }

            return emails;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Email email) {

        String sql = "update web_crawling_email set name = ? where email = ?";

        try (Connection connection = DbUtils.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email.getName());
            preparedStatement.setString(4, email.getEmail());

            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteByEmail(String email) {

        String sql = "delete from web_crawling_email where email = ?";

        try (Connection connection = DbUtils.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);

            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
