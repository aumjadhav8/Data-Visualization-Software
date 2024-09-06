# Data Visualization App

Welcome to the **Data Visualization App**! This Java application allows users to visualize data through interactive pie and bar charts. The app is built using Swing for the graphical interface and provides an intuitive way to manage and visualize data.

## Features

- **Add Data**: Input integer data to visualize.
- **Generate Charts**: Create and display pie and bar charts based on the entered data.
- **Interactive Visualization**: View dynamic charts with real-time updates.

## Getting Started

### Prerequisites

- **Java JDK 8 or higher**: Ensure you have Java installed on your system.
- **IDE**: Any Java IDE like IntelliJ IDEA, Eclipse, or even a simple text editor.

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/datavisualization-app.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd datavisualization-app
   ```

3. **Compile and Run**:
   ```bash
   javac DataVisualizationApp.java
   java DataVisualizationApp
   ```

### Usage

1. **Add Data**:
   - Enter an integer value in the input field.
   - Click the "Add Data" button to add the value to the dataset.

2. **Generate Charts**:
   - Click the "Generate Charts" button to create and view the pie and bar charts.

3. **Visualization**:
   - The pie chart will be displayed in the central panel.
   - The bar chart will appear in the right panel.

## Code Overview

- **`DataVisualizationApp`**: Main class that sets up the GUI and handles user interactions.
  - **`piePanel`**: Panel for displaying the pie chart.
  - **`barPanel`**: Panel for displaying the bar chart.
  - **`dataInputField`**: Text field for entering data.
  - **`addDataButton`**: Button to add data to the dataset.
  - **`generateButton`**: Button to generate and display the charts.

- **Methods**:
  - **`createBarChart(int[] data)`**: Creates a bar chart from the input data.
  - **`createPieChart(int[] data)`**: Creates a pie chart from the input data.
  - **`getMaxValue(int[] data)`**: Finds the maximum value in the data array.
  - **`getRandomColor()`**: Generates a random color for pie chart slices.

## Screenshots

### Pie Chart & Bar Chart
![Demo](https://github.com/aumjadhav8/Data-Visualization-Software/blob/main/demo.png)

## Contributing

If you would like to contribute to this project, please fork the repository and submit a pull request with your changes. We welcome bug reports, feature requests, and improvements!

## Acknowledgements

- **Java Swing**: For creating the graphical user interface.

Happy Visualizing! 🚀
