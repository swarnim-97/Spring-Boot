package dev.swarnim.todoapp.data;

import dev.swarnim.todoapp.models.Note;
import dev.swarnim.todoapp.models.User;
import dev.swarnim.todoapp.utils.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Component
public class Data {

    private String name;
    private UUID uuid;
    private Constants.Gender gender;
    private HashMap<UUID, String> map;

    public Data(){
        map = new HashMap<>();
    }

    public String toString(){
        return name+" "+uuid+" "+gender+" "+map;
    }
}
