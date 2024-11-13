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

    private double n1 = 0;
    private String operador = "";
    private boolean novoNumero = true;

    public Calculadora_Simples() {
        ActionListener adicionarNumero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                String numero = btn.getText();

                if (novoNumero == true) {
                    txtResultado.setText(numero);
                    novoNumero = false;
                } else {
                    if (txtResultado.getText().length() < 8) {
                        txtResultado.setText(txtResultado.getText() + numero);
                    }
                }
            }
        };

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNumero("1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNumero("2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNumero("3");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNumero("4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNumero("5");
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNumero("6");
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNumero("7");
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNumero("8");
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNumero("9");
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarNumero("0");
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText("");
                n1 = 0;
                operador = "";
                novoNumero = true;
            }
        });


        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                definirOperacao("+");
            }
        });

        btnSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                definirOperacao("-");
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                definirOperacao("*");
            }
        });

        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                definirOperacao("/");
            }
        });

        btnResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacao();
                operador = "";
                novoNumero = true;
            }
        });
    }

    private void adicionarNumero(String numero) {
        if (novoNumero == true) {
            txtResultado.setText(numero);
            novoNumero = false;
        } else {
            if (txtResultado.getText().length() < 8) {
                txtResultado.setText(txtResultado.getText() + numero);
            }
        }
    }

    private void definirOperacao(String op) {
        if (!novoNumero == true) {
            realizarOperacao();
        }
        operador = op;
        n1 = Double.parseDouble(txtResultado.getText());
        novoNumero = true;
    }

    private void realizarOperacao() {
        double n2 = Double.parseDouble(txtResultado.getText());

        switch (operador) {
            case "+":
                n1 += n2;
                break;
            case "-":
                n1 -= n2;
                break;
            case "*":
                n1 *= n2;
                break;
            case "/":
                if (n2 != 0) {
                    n1 /= n2;
                } else {
                    txtResultado.setText("Erro");
                    return;
                }
                break;
        }
        String resultado = String.valueOf(n1);
        if (resultado.length() > 8) {
            resultado = resultado.substring(0, 8);
        }
        txtResultado.setText(resultado);
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora_Simples");
        frame.setContentPane(new Calculadora_Simples().Calculadora);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}