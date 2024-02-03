import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataVisualizationApp extends JFrame {

    private List<Integer> inputData;
    private JPanel piePanel;
    private JPanel barPanel;
    private JTextField dataInputField;
    private JButton addDataButton;
    private JButton generateButton;

    public DataVisualizationApp() {
        // Set up the frame
        setTitle("Data Visualization App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize the input data list
        inputData = new ArrayList<>();

        // Create a panel for the pie chart
        piePanel = new JPanel();
        piePanel.setPreferredSize(new Dimension(800, 600)); // Increase the size of the pie chart
        piePanel.setLayout(new BorderLayout());

        // Create a panel for the bar graph
        barPanel = new JPanel();
        barPanel.setPreferredSize(new Dimension(400, 600)); // Reduce the width of the bar chart
        barPanel.setLayout(new BorderLayout());

        // Create a panel for user input
        JPanel inputPanel = new JPanel(new FlowLayout());

        dataInputField = new JTextField(10);
        inputPanel.add(dataInputField);

        addDataButton = new JButton("Add Data");
        inputPanel.add(addDataButton);

        generateButton = new JButton("Generate Charts");
        inputPanel.add(generateButton);

        add(inputPanel, BorderLayout.NORTH);
        add(piePanel, BorderLayout.CENTER);
        add(barPanel, BorderLayout.EAST); // Add the barPanel to the frame

        // Add action listeners to the buttons
        addDataButton.addActionListener(e -> {
            String inputDataString = dataInputField.getText();
            try {
                int data = Integer.parseInt(inputDataString);
                inputData.add(data);
                dataInputField.setText("");
                JOptionPane.showMessageDialog(this, "Data added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer.");
            }
        });

        generateButton.addActionListener(e -> {
            if (!inputData.isEmpty()) {
                int[] chartData = inputData.stream().mapToInt(Integer::intValue).toArray();
                JPanel pieChart = createPieChart(chartData);
                JPanel barChart = createBarChart(chartData);

                piePanel.removeAll();
                piePanel.add(pieChart, BorderLayout.CENTER);

                barPanel.removeAll();
                barPanel.add(barChart, BorderLayout.CENTER);

                validate();
            } else {
                JOptionPane.showMessageDialog(this, "Please add data before generating the charts.");
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createBarChart(int[] data) {
        JPanel chart = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                int width = getWidth();
                int height = getHeight();
                int barWidth = width / data.length;
                int barSpacing = 10; // Spacing between bars

                int maxDataValue = getMaxValue(data);

                // Set bold and big font for labels
                Font labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 18);
                g2d.setFont(labelFont);

                for (int i = 0; i < data.length; i++) {
                    int barHeight = (int) ((double) data[i] / maxDataValue * height);
                    int x = i * (barWidth + barSpacing);
                    int y = height - barHeight;
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(x, y, barWidth, barHeight);

                    // Label the bars with "a", "b", "c", etc.
                    g2d.setColor(Color.BLACK);
                    g2d.drawString(String.valueOf((char) ('a' + i)), x + barWidth / 2 - 5, height - 5);
                }

                g2d.dispose();
            }

            private int getMaxValue(int[] data) {
                int max = Integer.MIN_VALUE;
                for (int value : data) {
                    if (value > max) {
                        max = value;
                    }
                }
                return max;
            }
        };

        return chart;
    }

    private JPanel createPieChart(int[] data) {
        JPanel chart = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                int width = getWidth();
                int height = getHeight();
                int pieSize = Math.min(width, height) - 20; // Size of the pie chart
                int cx = width / 2; // X-coordinate of the center
                int cy = height / 2; // Y-coordinate of the center

                int total = 0;
                for (int value : data) {
                    total += value;
                }

                // Set bold and big font for labels
                Font labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 18);
                g2d.setFont(labelFont);

                double startAngle = 0;
                for (int i = 0; i < data.length; i++) {
                    double angle = 360.0 * data[i] / total;
                    g2d.setColor(getRandomColor());
                    g2d.fill(new Arc2D.Double(cx - pieSize / 2, cy - pieSize / 2, pieSize, pieSize, startAngle, angle, Arc2D.PIE));

                    // Label the pie slices with "a", "b", "c", etc.
                    g2d.setColor(Color.BLACK);
                    int labelX = (int) (cx + (pieSize / 2) * Math.cos(Math.toRadians(startAngle + angle / 2)));
                    int labelY = (int) (cy + (pieSize / 2) * Math.sin(Math.toRadians(startAngle + angle / 2)));
                    g2d.drawString(String.valueOf((char) ('a' + i)), labelX - 5, labelY);

                    startAngle += angle;
                }

                g2d.dispose();
            }

            private Color getRandomColor() {
                Random random = new Random();
                int r = random.nextInt(256);
                int g = random.nextInt(256);
                int b = random.nextInt(256);
                return new Color(r, g, b);
            }
        };

        return chart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataVisualizationApp());
    }
}
