package View;

import Model.Events.Event;
import Model.Factory.FactoryStats;
import Model.Events.Observer;
import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel implements Observer {
    private final FactoryStats stats;

    private JLabel acsStoredCountLabel;
    private JLabel bodyStoredCountLabel;
    private JLabel engineStoredCountLabel;
    private JLabel carStoredCountLabel;
    private JLabel acsProdCountLabel;
    private JLabel bodyProdCountLabel;
    private JLabel engineProdCountLabel;
    private JLabel carsProdCountLabel;

    public StatsPanel(FactoryStats stats) {
        super(new GridBagLayout());
        this.stats = stats;

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.ORANGE);

        addLabels();
    }

    private void addLabels() {
        acsStoredCountLabel = createLabel();
        acsStoredCountLabel.setText("Accessories in storage: " + stats.getAccessoryStoredCount());
        this.add(acsStoredCountLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        bodyStoredCountLabel = createLabel();
        bodyStoredCountLabel.setText("Bodies in storage: " + stats.getBodyStoredCount());
        this.add(bodyStoredCountLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        engineStoredCountLabel = createLabel();
        engineStoredCountLabel.setText("Engines in storage: " + stats.getEngineStoredCount());
        this.add(engineStoredCountLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        carStoredCountLabel = createLabel();
        carStoredCountLabel.setText("Cars in storage: " + stats.getCarStoredCount());
        this.add(carStoredCountLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        acsProdCountLabel = createLabel();
        acsProdCountLabel.setText("Accessories produced: " + stats.getAccessoryProducedCount());
        this.add(acsProdCountLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        bodyProdCountLabel = createLabel();
        bodyProdCountLabel.setText("Body produced: " + stats.getBodyProducedCount());
        this.add(bodyProdCountLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        engineProdCountLabel = createLabel();
        engineProdCountLabel.setText("Engines produced: " + stats.getEngineProducedCount());
        this.add(engineProdCountLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        carsProdCountLabel = createLabel();
        carsProdCountLabel.setText("Cars produced: " + stats.getCarProducedCount());
        this.add(carsProdCountLabel, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

    }

    private JLabel createLabel() {
        JLabel label = new JLabel();
        label.setFont(new Font("Arial", Font.BOLD, 24));
        return label;
    }

    @Override
    public void update(Event event) {
        switch (event.getEventType()) {
            case UPD_ACCESSORY_STORED_COUNT:
                acsStoredCountLabel.setText("Accessories in storage: " + stats.getAccessoryStoredCount());
                break;

            case UPD_BODY_STORED_COUNT:
                bodyStoredCountLabel.setText("Bodies in storage: " + stats.getBodyStoredCount());
                break;

            case UPD_ENGINE_STORED_COUNT:
                engineStoredCountLabel.setText("Engines in storage: " + stats.getEngineStoredCount());
                break;

            case UPD_CAR_STORED_COUNT:
                carStoredCountLabel.setText("Cars in storage: " + stats.getCarStoredCount());
                break;

            case UPD_ACCESSORY_PROD_COUNT:
                acsProdCountLabel.setText("Accessories produced: " + stats.getAccessoryProducedCount());
                break;

            case UPD_BODY_PROD_COUNT:
                bodyProdCountLabel.setText("Bodies produced: " + stats.getBodyProducedCount());
                break;

            case UPD_ENGINE_PROD_COUNT:
                engineProdCountLabel.setText("Engines produced: " + stats.getEngineProducedCount());
                break;

            case UPD_CAR_PROD_COUNT:
                carsProdCountLabel.setText("Cars produced: " + stats.getCarProducedCount());
                break;
        }
    }
}