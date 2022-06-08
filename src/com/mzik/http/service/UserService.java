package com.mzik.http.service;

import com.mzik.http.dao.UserDao;
import com.mzik.http.dto.CreateUserDto;
import com.mzik.http.dto.UserDto;
import com.mzik.http.entity.User;
import com.mzik.http.exception.ValidationException;
import com.mzik.http.mapper.CreateUserMapper;
import com.mzik.http.mapper.UserMapper;
import com.mzik.http.validator.CreateUserValidator;
import com.mzik.http.validator.ValidationResult;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Optional;

@NoArgsConstructor
public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(userMapper::mapFrom);
    }

    @SneakyThrows
    public Integer create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        userDao.save(userEntity);

        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
