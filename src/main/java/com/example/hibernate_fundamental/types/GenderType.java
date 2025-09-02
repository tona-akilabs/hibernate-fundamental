package com.example.hibernate_fundamental.types;

import com.example.hibernate_fundamental.enums.Gender;
import org.hibernate.usertype.UserTypeSupport;

import java.sql.Types;

public class GenderType extends UserTypeSupport<Gender> {
    public GenderType() {
        super(Gender.class, Types.CHAR);
    }
}
