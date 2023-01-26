package service;
import dao.UserDao;
import dto.UserCreate;
import entity.User;
import lombok.Data;
@Data
public class UserService {

    private static final UserService INSTANCE = new UserService();
    private final UserDao userDao = UserDao.getInstance();

    private UserService() {
    }

    public void create(UserCreate userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .country(userDto.getCountry())
                .build();
        userDao.save(user);
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
