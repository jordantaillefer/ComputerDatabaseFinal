package com.main.excilys.mapper;

import java.util.ArrayList;
import java.util.List;

import com.main.excilys.model.User;
import com.main.excilys.model.UserRole;
import com.main.excilys.model.dto.UserDto;

public class UserToDtoMapper {
    public static User toUser(UserDto userDto) {
        List<UserRole> userRoles = new ArrayList<>();
        if (userDto.getRole() != null) {
            String roles[] = userDto.getRole().split(", ");
            for (String role : roles) {
                UserRole userRole = new UserRole(userDto.getUsername(), role);
                userRoles.add(userRole);
            }
        }
        User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.isEnabled());
        user.setUserRoles(userRoles);
        return user;
    }

    public static UserDto toUserDto(User user) {
        StringBuilder sb = new StringBuilder();
        user.getUserRoles().forEach(roles -> sb.append(roles.getRole() + ", "));
        String roles = sb.length() > 2 ? sb.substring(0, sb.length() - 2) : "";
        return new UserDto(user.getUsername(), user.getPassword(), user.isEnabled(), roles);
    }

}
