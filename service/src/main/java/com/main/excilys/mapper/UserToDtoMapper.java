package com.main.excilys.mapper;

import com.main.excilys.model.User;
import com.main.excilys.model.dto.UserDto;

public class UserToDtoMapper {
  public static User toUser(UserDto userDto) {
    return new User(userDto.getUsername(), userDto.getPassword(), userDto.isEnabled());
  }

    public static UserDto toUserDto(User user) {
      StringBuilder sb = new StringBuilder();
        user.getUserRoles().forEach(roles -> sb.append(roles.getRole() + ", "));
        return new UserDto(user.getUsername(), user.getPassword(), user.isEnabled(),
                sb.substring(0, sb.length() - 2));
  }

}
