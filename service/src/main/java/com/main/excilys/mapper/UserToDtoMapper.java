package com.main.excilys.mapper;

import com.main.excilys.model.User;
import com.main.excilys.model.UserRole;
import com.main.excilys.model.dto.UserDto;

public class UserToDtoMapper {
  public static User toUser(UserDto userDto) {
    return new User(userDto.getUsername(), userDto.getPassword(), userDto.isEnabled());
  }

  public static UserDto toUserDto(User user, UserRole userRole) {
    return new UserDto(user.getUsername(), user.getPassword(), user.isEnabled(),
        userRole.getRole());
  }

}
