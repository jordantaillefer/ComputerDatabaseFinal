package com.main.excilys.mapper;

import java.util.ArrayList;
import java.util.List;

import com.main.excilys.model.User;
import com.main.excilys.model.UserRole;
import com.main.excilys.model.dto.UserDto;

public class UserToDtoMapper {
    public static User toUser(UserDto userDto) {
        List<UserRole> userRoles = new ArrayList<>();
        boolean userRolePresent = false;
        if (userDto.getRole() != null) {
            String roles[] = userDto.getRole().split(", ");
            for (String role : roles) {
                UserRole userRole = new UserRole(userDto.getUsername(), role);
                if (userRole.getRole().equals("ROLE_USER")) {
                    userRolePresent = true;
                }
                userRoles.add(userRole);
            }
            if (!userRolePresent) {
                userRoles.add(new UserRole(userDto.getUsername(), "ROLE_USER"));
            }
        }
        User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.isEnabled());
        user.setUserRoles(userRoles);
        return user;
    }

    public static UserDto toUserDto(User user) {
        StringBuilder sb = new StringBuilder();
        user.getUserRoles().forEach(roles -> {
            if (roles.getRole().equals("ROLE_ADMIN")) {
                sb.append("ROLE_ADMIN");
            }
        });
        return new UserDto(user.getUsername(), user.getPassword(), user.isEnabled(), sb.toString());
    }

}
