package dev.swarnim.todoapp.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Entity(name="NOTE")
public class Note {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(32)")
    private UUID noteUuid;

    @Column
    private String note;

    @Column
    private boolean isDeleted;

    public Note(){}

    public Note(String note){
        this.note = note;
        this.isDeleted = false;
    }

    public String toString(){
        return noteUuid+" "+note;
    }
}
