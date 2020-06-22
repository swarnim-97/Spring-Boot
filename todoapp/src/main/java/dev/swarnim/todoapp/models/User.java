package dev.swarnim.todoapp.models;

import dev.swarnim.todoapp.utils.Constants;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name="USER")
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(32)")
    private UUID user_id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Constants.Gender gender;

    @ElementCollection
    @Column(columnDefinition = "BINARY(32)")
    @CollectionTable(joinColumns = @JoinColumn(name = "user_id"))
    private List<UUID> noteId;

    @Column
    private boolean isDeleted;

    public User(){}

    public User(String name, Constants.Gender gender){
        this.name=name;
        this.gender=gender;
//        this.user_id = UUID.randomUUID();
        this.noteId = new ArrayList<>();
        this.isDeleted = false;
    }

    public String toString(){
        return name+" "+user_id+" "+" "+gender+" "+noteId+" "+isDeleted;
    }
}
