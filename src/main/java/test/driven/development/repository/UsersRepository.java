package test.driven.development.repository;

import test.driven.development.model.User;

public interface UsersRepository {
    boolean save(User user);
}
