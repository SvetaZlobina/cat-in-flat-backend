package org.hops.backend.api.controller;

import org.hops.backend.api.entity.Home;
import org.hops.backend.api.entity.User;
import org.hops.backend.api.model.HomeInfo;
import org.hops.backend.api.repository.HomeRepository;
import org.hops.backend.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("home")
public class HomeController {
    private final HomeRepository homeRepository;
    private final UserRepository userRepository;

    @Autowired
    public HomeController(
            HomeRepository homeRepository,
            UserRepository userRepository) {
        this.homeRepository = homeRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<HomeInfo> createHome(
            @RequestBody Home home,
            @RequestParam(name = "userId") long userId) {
        try {
            User user = userRepository.findById(userId).orElse(null);
            if (null == user) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            Home newHome = homeRepository.save(new Home(user, home.getTitle()));
            return new ResponseEntity<>(
                    new HomeInfo(newHome.getId(), newHome.getUser().getId(), newHome.getTitle()),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<HomeInfo>> getHomesByUser(@RequestParam(name = "userId") long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (null == user) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        List<Home> homes = homeRepository.findAllByUser(user);
        return new ResponseEntity<>(
                homes.stream().map(Home::convertToHomeInfo).collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{homeId}")
    public ResponseEntity<Void> deleteHome(@PathVariable(value = "homeId") long homeId) {
        try {
            homeRepository.deleteById(homeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
