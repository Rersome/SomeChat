package com.example.somechat;

public class User {

    private String name;
    private String email;
    private String id;
    private int avatarMockUpResource;

    public User() {

    }

    public User(String name, String email, String id, int avatarMockUpResource){
        this.name = name;
        this.email = email;
        this.id = id;
        this.avatarMockUpResource = avatarMockUpResource;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setId (String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setAvatarMockUpResource(int avatarMockUpResource){
        this.avatarMockUpResource = avatarMockUpResource;
    }

    public int getAvatarMockUpResource(){
        return avatarMockUpResource;
    }

}
