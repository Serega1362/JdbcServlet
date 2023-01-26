package dao;

import entity.User;
import lombok.SneakyThrows;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao implements Dao<Integer, User> {

    private static final UserDao INSTANCE = new UserDao();
    private static final String SAVE_SQL = "INSERT INTO user(name, country) VALUES (?, ?)";

    public UserDao() {

    }
    @Override
    @SneakyThrows
    public User save(User entity) {
        try (Connection connection = ConnectionUtil.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getCountry());

            preparedStatement.executeUpdate();

            return entity;
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

}