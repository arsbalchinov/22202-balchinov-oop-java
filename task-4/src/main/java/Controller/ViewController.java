package Controller;

import Model.Factory.Factory;
import Model.Events.Observable;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public abstract class ViewController extends Observable implements ChangeListener {
    protected final Factory factory;

    public ViewController(Factory factory) {
        this.factory = factory;
    }

    @Override
    public abstract void stateChanged(ChangeEvent e);
}