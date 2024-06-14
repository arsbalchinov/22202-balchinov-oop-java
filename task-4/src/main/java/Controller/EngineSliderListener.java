package Controller;

import Model.Factory.Factory;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class EngineSliderListener extends ViewController {
    public EngineSliderListener(Factory factory) {
        super(factory);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int newValue = ((JSlider) e.getSource()).getValue();
        factory.setEngineTimeToSupply(newValue * 1000);
    }
}