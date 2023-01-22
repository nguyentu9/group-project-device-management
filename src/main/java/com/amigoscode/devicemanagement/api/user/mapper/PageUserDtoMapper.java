package com.amigoscode.devicemanagement.api.user.mapper;

import com.amigoscode.devicemanagement.api.user.dto.PageUserDto;
import com.amigoscode.devicemanagement.api.user.dto.UserDto;
import com.amigoscode.devicemanagement.domain.user.model.PageUser;
import com.amigoscode.devicemanagement.domain.user.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PageUserDtoMapper {

    @Mapping(target = "users", qualifiedByName = "toUserDtoList")
    PageUserDto toPageDto(PageUser domain);

    @Named("toUserDtoList")
    @IterableMapping(qualifiedByName = "userToUserDto")
    List<UserDto> toListDto(List<User> users);

    @Named("userToUserDto")
    @Mapping(target="password", constant = "######")
    UserDto toDto(User domain);
}