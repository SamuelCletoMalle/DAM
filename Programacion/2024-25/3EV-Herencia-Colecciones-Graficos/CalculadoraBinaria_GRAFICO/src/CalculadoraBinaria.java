import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraBinaria extends JFrame implements ActionListener {
    private JTextField resultField;
    private StringBuilder currentInput;

    public CalculadoraBinaria() {
        currentInput = new StringBuilder();

        // Configuración de la ventana
        setTitle("Calculadora Binaria");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 4));

        // Campo de texto para mostrar el resultado
        resultField = new JTextField("0");
        resultField.setFont(new Font("Arial", Font.PLAIN, 24));
        resultField.setEditable(false);
        add(resultField);

        // Botones
        String[] buttons = {"0", "1", "C", "+"};
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
            add(button);
        }

        JButton equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        equalsButton.addActionListener(this);
        add(equalsButton);
        equalsButton.setBounds(new Rectangle(500,50,100,75));

        // Configurar el tamaño de las filas y columnas
        for (int i = 0; i < 4; i++) {
            add(new JLabel()); // Espacios vacíos para completar la cuadrícula
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
            currentInput.setLength(0); // Limpiar la entrada
            resultField.setText("0");
        } else if (command.equals("=")) {
            calculateResult();
        } else {
            currentInput.append(command);
            resultField.setText(currentInput.toString());
        }
    }

    private void calculateResult() {
        String[] binaryNumbers = currentInput.toString().split("\\+");
        int total = 0;

        try {
            for (String binary : binaryNumbers) {
                total += Integer.parseInt(binary, 2); // Convertir de binario a decimal
            }
            resultField.setText(Integer.toBinaryString(total)); // Convertir el total a binario
        } catch (NumberFormatException e) {
            resultField.setText("Error");
        }
    }

    public static void main(String[] args) {
        // Crear la instancia de la calculadora en el hilo de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraBinaria();
            }
        });
    }
}