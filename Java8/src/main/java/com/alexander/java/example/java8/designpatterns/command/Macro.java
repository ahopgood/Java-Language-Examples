package com.alexander.java.example.java8.designpatterns.command;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexander on 25/04/2017.
 */
public class Macro {
    
    private final List<Action> actions;

    public Macro() {
        actions = new LinkedList<>();
    }
    
    public void record(Action action){
        actions.add(action);
    }
    
    public void run(){
        actions.forEach(Action::perform);
    }
    
    public static void main(String[] args){
        Editor editor = new GuiEditor();
        Macro macro = new Macro();
        macro.record(() -> editor.open());
        macro.record(() -> editor.save());
        macro.record(() -> editor.close());
        macro.run();

        macro.record(editor::open);
        macro.record(editor::save);
        macro.record(editor::close);
        macro.run();
    }
}
