package com.example.bugtracker;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.apache.logging.log4j.message.Message;

@Entity
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message ="Title cannot be empty")
//    @Size(min = 10, message = "title must be at least 10 characters long")
    private  String title;
@NotBlank(message ="please write description")
    private String description;
    private String status;
    private String priority;
    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    public Bug(){}
    public Bug(String title,String description,String status,String priority){
        this.title=title;
        this.description=description;
        this.status= status;
        this.priority=priority;
    }
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){this.description=description;}

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    public User getAssignee() { return assignee; }
    public void setAssignee(User assignee) { this.assignee = assignee; }
}
