package com.main.excilys.service;

import com.main.excilys.mapper.UserToDtoMapper;
import com.main.excilys.model.UserRole;
import com.main.excilys.model.dto.UserDto;
import com.main.excilys.repository.UserRepository;
import com.main.excilys.repository.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
