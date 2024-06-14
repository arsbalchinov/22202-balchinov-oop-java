package Controller;

import Model.Factory.Factory;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class DealerSliderListener extends ViewController {
    public DealerSliderListener(Factory factory) {
        super(factory);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int newValue = ((JSlider) e.getSource()).getValue();
        factory.setDealersTimeToSale(newValue * 1000);
    }
}