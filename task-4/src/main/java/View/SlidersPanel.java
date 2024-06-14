package View;

import Controller.AccessoriesSliderListener;
import Controller.BodySliderListener;
import Controller.DealerSliderListener;
import Controller.EngineSliderListener;
import Model.Factory.Factory;
import javax.swing.*;
import java.awt.*;

public class SlidersPanel extends JPanel {
    public SlidersPanel(Factory factory) {
        super(new GridBagLayout());

        JLabel acsTimeLabel = createLabel("Accessory Supply Time");
        JSlider acsTimeSlider = createSlider(1, 10, 1, 1);
        acsTimeSlider.addChangeListener(new AccessoriesSliderListener(factory));
        this.add(acsTimeLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 1, 5), 0, 0));
        this.add(acsTimeSlider, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 20, 5), 0, 0));


        JLabel bodyTimeLabel = createLabel("Body Supply Time");
        JSlider bodyTimeSlider = createSlider(1, 10, 1, 1);
        bodyTimeSlider.addChangeListener(new BodySliderListener(factory));
        this.add(bodyTimeLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 1, 5), 0, 0));
        this.add(bodyTimeSlider, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 20, 5), 0, 0));

        JLabel motorTimeLabel = createLabel("Engine Supply Time");
        JSlider motorTimeSlider = createSlider(1, 10, 1, 1);
        motorTimeSlider.addChangeListener(new EngineSliderListener(factory));
        this.add(motorTimeLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 1, 5), 0, 0));
        this.add(motorTimeSlider, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel dealerTimeLabel = createLabel("Dealer Sale Time");
        JSlider dealerTimeSlider = createSlider(1, 10, 1, 1);
        dealerTimeSlider.addChangeListener(new DealerSliderListener(factory));
        this.add(dealerTimeLabel, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 1, 5), 0, 0));
        this.add(dealerTimeSlider, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.ORANGE);
    }

    private JSlider createSlider(int begin, int end, int interval, int start) {
        JSlider slider = new JSlider(begin, end, start);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(interval);
        slider.setPreferredSize(new Dimension(400, 100));
        return slider;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(400, 35));
        label.setFont(new Font("Arial", Font.BOLD, 24));
        return label;
    }
}