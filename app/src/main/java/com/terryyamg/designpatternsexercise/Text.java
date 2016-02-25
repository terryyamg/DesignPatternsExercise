package com.terryyamg.designpatternsexercise;

public abstract class Text{
    private String message;

    String getMessage(){
        return message;
    }
    void setMessage(String message){
        this.message = message;
    }

    public abstract void input();
    public abstract void type();
    public abstract void length();
}
