package com.terryyamg.designpatternsexercise;

import android.util.Log;

public abstract class CheckText {
    public static boolean TYPE;
    public static int LENGTH;

    public void input(String message){
        Text text = createText();
        text.setMessage(message);
        type(text);
        length(text);
        text.input();
    }

    //類型
    public void type(Text text){
        if(isInteger(text.getMessage())){ // int
            TYPE = true;
        }else{ // string
            TYPE = false;
        }
        text.type();
    }


    //長度
    public void length(Text text){
        LENGTH = text.getMessage().length();
        Log.i("lllllll",LENGTH+"");
        text.length();
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            Log.i("NumberFormatException",e+"");
            return false;
        } catch(NullPointerException e) {
            Log.i("NullPointerException",e+"");
            return false;
        }
        Log.i("true","true");
        return true;
    }

    public abstract Text createText();
}

