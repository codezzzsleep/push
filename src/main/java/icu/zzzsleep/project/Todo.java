package icu.zzzsleep.project;

import lombok.Data;

import java.sql.Date;

@Data
public class Todo {
    private int id;
    private int userid;
    private int status;
    private int isDelete;
    private String title;
    private String message;
    private Date createTime;
    private Date endTime;
    private Date updateTime;
}
