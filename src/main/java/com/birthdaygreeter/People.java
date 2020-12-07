package com.birthdaygreeter;

import java.util.Date;
import java.text.SimpleDateFormat;

public class People
{

    private String name;
    private String email;
    private Date birthday;

    public People(String name, String email, String birthday) throws java.text.ParseException {
        this.name = name;
        this.email = email;
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.birthday = simpleDateFormat.parse(birthday);
    }
    
    public Date birthday() {
        return birthday;
    }
    
    public void greet() {
    }
};
