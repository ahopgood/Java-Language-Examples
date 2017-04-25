package com.alexander.java.examples.java7.designpatterns.command;

/**
 * Created by Alexander on 25/04/2017.
 */
public class Close implements Action{
    private final Editor editor;

    public Close(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.close();
    }
}
