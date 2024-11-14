import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora_Simples {
    private JPanel Calculadora;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnDividir;
    private JButton btnMultiplicar;
    private JButton btnSubtrair;
    private JButton btn0;
    private JButton btnSomar;
    private JButton btnResultado;
    private JButton btnLimpar;
    private JLabel txtResultado;

    private Double n1 = 0.0;
    private Double n2 = 0.0;
    private String operador = "";
    private Boolean novoNumero = true;

    public Calculadora_Simples() {
        txtResultado.setText("");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (novoNumero == true) {
                    txtResultado.setText("1");
                    novoNumero = false;
                } else {
                    txtResultado.setText(txtResultado.getText() + "1");
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (novoNumero == true) {
                    txtResultado.setText("2");
                    novoNumero = false;
                } else {
                    txtResultado.setText(txtResultado.getText() + "2");
                }
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (novoNumero == true) {
                    txtResultado.setText("3");
                    novoNumero = false;
                } else {
                    txtResultado.setText(txtResultado.getText() + "3");
                }
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (novoNumero == true) {
                    txtResultado.setText("4");
                    novoNumero = false;
                } else {
                    txtResultado.setText(txtResultado.getText() + "4");
                }
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (novoNumero == true) {
                    txtResultado.setText("5");
                    novoNumero = false;
                } else {
                    txtResultado.setText(txtResultado.getText() + "5");
                }
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (novoNumero == true) {
                    txtResultado.setText("6");
                    novoNumero = false;
                } else {
                    txtResultado.setText(txtResultado.getText() + "6");
                }
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (novoNumero == true) {
                    txtResultado.setText("7");
                    novoNumero = false;
                } else {
                    txtResultado.setText(txtResultado.getText() + "7");
                }
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (novoNumero == true) {
                    txtResultado.setText("8");
                    novoNumero = false;
                } else {
                    txtResultado.setText(txtResultado.getText() + "8");
                }
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (novoNumero == true) {
                    txtResultado.setText("9");
                    novoNumero = false;
                } else {
                    txtResultado.setText(txtResultado.getText() + "9");
                }
            }
        });

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (novoNumero == true) {
                    txtResultado.setText("0");
                    novoNumero = false;
                } else {
                    txtResultado.setText(txtResultado.getText() + "0");
                }
            }
        });

        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador = "+";
                n1 = Double.parseDouble(txtResultado.getText());
                novoNumero = true;
            }
        });

        btnSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador = "-";
                n1 = Double.parseDouble(txtResultado.getText());
                novoNumero = true;
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador = "*";
                n1 = Double.parseDouble(txtResultado.getText());
                novoNumero = true;
            }
        });

        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador = "/";
                n1 = Double.parseDouble(txtResultado.getText());
                novoNumero = true;
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText("");
                novoNumero = true;
            }
        });

        btnResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n2 = Double.parseDouble(txtResultado.getText());
                switch (operador) {
                    case "+" -> n1 = n1 + n2;
                    case "-" -> n1 = n1 - n2;
                    case "*" -> n1 = n1 * n2;
                    case "/" -> {
                        if (n2 != 0.0) {
                            n1 = n1 / n2;
                        } else {
                            txtResultado.setText("Erro");
                        }
                    }
                }
                txtResultado.setText(String.valueOf(n1));
                novoNumero = true;
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora_Simples");
        frame.setContentPane(new Calculadora_Simples().Calculadora);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}