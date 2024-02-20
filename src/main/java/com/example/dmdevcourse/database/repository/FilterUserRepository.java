package com.example.dmdevcourse.database.repository;

import com.example.dmdevcourse.database.entity.Role;
import com.example.dmdevcourse.database.entity.User;
import com.example.dmdevcourse.dto.PersonalInfo;
import com.example.dmdevcourse.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);
}
