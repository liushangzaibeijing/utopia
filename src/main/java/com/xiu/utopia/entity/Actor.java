package com.xiu.utopia.entity;

public class Actor {
    //{id:'1',isDirector:true,avatars:"./avatar.jpg",name:'贾斯丁比伯'}]
    private Integer id;

    private boolean isDirector;

    private String avatars;

    private String name;


    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

    public void setDirector(boolean director) {
        isDirector = director;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getAvatars() {
        return avatars;
    }

    public String getName() {
        return name;
    }
}
