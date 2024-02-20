package com.example.dmdevcourse.dto;

import com.example.dmdevcourse.database.entity.Role;
import com.example.dmdevcourse.validation.UserInfo;
import com.example.dmdevcourse.validation.group.CreateAction;
import com.example.dmdevcourse.validation.group.UpdateAction;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.postgresql.util.LruCache;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo(groups = CreateAction.class)
public class UserCreateEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;


    @Size(min = 3, max = 64)
    String firstname;


    String lastname;

    Role role;
    
    Integer companyId;

}
