package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PieChart {
    private JTextField item;
    private JTextField amount;
    private JButton addDataButton;
    private JButton pieChartButton;
    private JButton resetButton;
    private JTable table;
    private DefaultTableModel model;
    private JPanel mainPanel;
    private JPanel piePanel;
    private JPanel tablePanel;

    public PieChart() {
        // Frame setup
        JFrame frame = new JFrame("Pie Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Main panel
        mainPanel = new JPanel(new BorderLayout());

        // Top form panel
        JPanel inputPanel = new JPanel();
        item = new JTextField(10);
        amount = new JTextField(10);
        addDataButton = new JButton("Add Data");
        pieChartButton = new JButton("Pie Chart");
        resetButton = new JButton("Reset");

        inputPanel.add(new JLabel("Item:"));
        inputPanel.add(item);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amount);
        inputPanel.add(addDataButton);
        inputPanel.add(pieChartButton);
        inputPanel.add(resetButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Table panel
        tablePanel = new JPanel();
        String[] columns = {"ITEM", "AMOUNT"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        tablePanel.add(new JScrollPane(table));
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        // Pie chart panel
        piePanel = new JPanel();
        piePanel.setPreferredSize(new Dimension(400, 300));
        mainPanel.add(piePanel, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);

        // Action listeners
        addDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = item.getText();
                String amountData = amount.getText();
                if (!itemName.isEmpty() && !amountData.isEmpty()) {
                    try {
                        Double.parseDouble(amountData); // validate amount
                        model.addRow(new Object[]{itemName, amountData});
                        item.setText("");
                        amount.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Amount must be a number");
                    }
                }
            }
        });

        pieChartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piePanel.removeAll();
                showPieChart();
                frame.revalidate();
                frame.repaint();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                piePanel.removeAll();
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    private void showPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < model.getRowCount(); i++) {
            String name = model.getValueAt(i, 0).toString();
            Double value = Double.valueOf(model.getValueAt(i, 1).toString());
            dataset.setValue(name, value);
        }

        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 300));
        piePanel.add(chartPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PieChart::new);
    }
}
