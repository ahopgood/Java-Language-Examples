package com.alexander.java.examples.java7.designpatterns.command;

/**
 * Created by Alexander on 25/04/2017.
 */
public class Save implements Action {
    private final Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}
