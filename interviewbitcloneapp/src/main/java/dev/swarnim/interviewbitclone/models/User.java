package dev.swarnim.interviewbitclone.models;

import dev.swarnim.interviewbitclone.utils.Constants;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID uuid;
    private String name;
    private Constants.Gender gender;
    private boolean isDelete;


    public User(){}

    public User(String name, Constants.Gender gender){
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.gender = gender;
        this.isDelete = false;
    }

    public String toString(){
        return uuid+" "+name+" "+gender+" "+isDelete;
    }

}
