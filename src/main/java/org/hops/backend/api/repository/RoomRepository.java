package org.hops.backend.api.repository;

import org.hops.backend.api.entity.Home;
import org.hops.backend.api.entity.Room;
import org.hops.backend.api.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAllByHome(Home home);
}
