package com.alexander.java.examples.java7.designpatterns.command;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexander on 25/04/2017.
 */
public class Macro {
    private final List<Action> actions;

    public Macro() {
        this.actions = new LinkedList<>();
    }
    
    public void record(Action action){
        actions.add(action);
    }
    
    public void run(){
        for (Action action : actions){
            action.perform();
        }
    }
    
    public static void main(String[] args){
        Editor editor = new GuiEditor();
        Macro macro = new Macro();
        macro.record(new Open(editor));
        macro.record(new Save(editor));
        macro.record(new Close(editor));
        macro.run();
    }
}
