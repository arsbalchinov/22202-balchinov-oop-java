package Controller;

import Model.Factory.Factory;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class AccessoriesSliderListener extends ViewController {
    public AccessoriesSliderListener(Factory factory) {
        super(factory);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int newValue = ((JSlider) e.getSource()).getValue();
        factory.setAccessoriesTimeToSupply(newValue * 1000);
    }
}