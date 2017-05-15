package com.main.excilys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.main.excilys.mapper.UserToDtoMapper;
import com.main.excilys.model.User;
import com.main.excilys.model.UserRole;
import com.main.excilys.model.dto.UserDto;
import com.main.excilys.repository.UserRepository;
import com.main.excilys.repository.UserRoleRepository;

@Repository
public class UserService {

    @Autowired
    UserRepository     userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Transactional
    public void addUser(UserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserRole userRole = new UserRole(userDto.getUsername(), "ROLE_USER");
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        User user = UserToDtoMapper.toUser(userDto);
        user.setUserRoles(userRoles);
        userRepository.save(user);
        userRoleRepository.save(userRole);
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> userDtos.add(UserToDtoMapper.toUserDto(user)));
        return userDtos;
    }

    public void promoteUser(String username) {
        List<UserRole> userRoles = userRoleRepository.findRolesForOneUser(username);
        List<UserRole> userRoleAdmin = userRoles.stream()
                .filter(userRole -> "ROLE_ADMIN".equals(userRole.getRole()))
                .collect(Collectors.toList());
        if (userRoleAdmin.size() == 0) {
            UserRole userRole = new UserRole(username, "ROLE_ADMIN");
            userRoleRepository.save(userRole);
        }
    }

    public int countUsersSearchByName(String search) {
        return userRepository.countSearchByName(search);
    }

}
