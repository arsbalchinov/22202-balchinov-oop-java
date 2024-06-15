package View;

import Model.Factory.Factory;
import Model.Factory.FactoryStats;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class FactoryView extends JFrame {
    private final Factory factory;

    public FactoryView(Factory factory, FactoryStats stats) {
        super("Factory");
        this.setLayout(new GridBagLayout());
        this.factory = factory;

        this.setSize(new Dimension(1280, 720));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setResizable(true);

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(FactoryView.class.getResource("/factory.gif")));
        JLabel label = new JLabel(icon);
        this.add(label, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JPanel configPanel = createConfigPanel();
        this.add(configPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        StatsPanel statsPanel = new StatsPanel(stats);
        stats.addObserver(statsPanel);
        this.add(statsPanel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        SlidersPanel slidersPanel = new SlidersPanel(factory);
        this.add(slidersPanel, new GridBagConstraints(1, 0, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        this.setVisible(true);
    }

    private JPanel createConfigPanel() {
        int accessoryStorageSize = factory.getConfig().getAccessoryStorageCapacity();
        int bodyStorageSize = factory.getConfig().getBodyStorageCapacity();
        int engineStorageSize = factory.getConfig().getEngineStorageCapacity();
        int accessorySuppliersCount = factory.getConfig().getAccessorySuppliers();
        int workersCount = factory.getConfig().getWorkers();
        int dealersCount = factory.getConfig().getDealers();

        JPanel panel = new JPanel(new GridBagLayout());

        JLabel logoLabel = createLabel("FACTORY CONFIGURATION");
        panel.add(logoLabel, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel acsStorageLabel = createLabel("Accessory Storage size: " + accessoryStorageSize);
        panel.add(acsStorageLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel bodyStorageLabel = createLabel("Body Storage size: " + bodyStorageSize);
        panel.add(bodyStorageLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel engineStorageLabel = createLabel("Engine Storage size: " + engineStorageSize);
        panel.add(engineStorageLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel acsSuppliersLabel = createLabel("Accessory Suppliers count: " + accessorySuppliersCount);
        panel.add(acsSuppliersLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel workersCntLabel = createLabel("Workers count: " + workersCount);
        panel.add(workersCntLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        JLabel dealersCntLabel = createLabel("Dealers count: " + dealersCount);
        panel.add(dealersCntLabel, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 5, 10, 5), 0, 0));

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBackground(Color.ORANGE);

        return panel;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        return label;
    }
}