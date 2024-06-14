package Controller;

import Model.Factory.Factory;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class BodySliderListener extends ViewController {
    public BodySliderListener(Factory factory) {
        super(factory);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int newValue = ((JSlider) e.getSource()).getValue();
        factory.setBodyTimeToSupply(newValue * 1000);
    }
}