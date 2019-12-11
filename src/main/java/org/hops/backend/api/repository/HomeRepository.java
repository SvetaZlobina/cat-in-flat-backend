package org.hops.backend.api.repository;

import org.hops.backend.api.entity.Home;
import org.hops.backend.api.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HomeRepository extends CrudRepository<Home, Long> {
    List<Home> findAllByUser(User user);
}
