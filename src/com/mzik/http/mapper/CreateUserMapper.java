package com.mzik.http.mapper;

import com.mzik.http.dto.CreateUserDto;
import com.mzik.http.entity.Gender;
import com.mzik.http.entity.Role;
import com.mzik.http.entity.User;
import com.mzik.http.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final String IMAGE_FOLDER = "users/";
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Role.valueOf(object.getRole()))
                .gender(Gender.valueOf(object.getGender()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
