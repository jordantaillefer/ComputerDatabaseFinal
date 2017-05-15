package com.main.excilys.service;

import java.util.ArrayList;
import java.util.List;

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
  UserRepository userRepository;

  @Autowired
  UserRoleRepository userRoleRepository;

  @Transactional
  public void addUser(UserDto userDto) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
    userRepository.save(UserToDtoMapper.toUser(userDto));
    userRoleRepository.save(new UserRole(userDto.getUsername(), "USER"));

  }

    public List<UserDto> findAll() { // TODO consider using lambdas
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            userDtos.add(UserToDtoMapper.toUserDto(user));
        }
        return userDtos;
    }

}
