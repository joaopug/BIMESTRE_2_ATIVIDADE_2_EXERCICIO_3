import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Notas_e_Media {
    private JTextArea txtAreaNotas;
    private JTextField txtNota;
    private JButton btnAdicionar;
    private JButton btnCalcularMedia;
    private JPanel Aplicativo_de_Notas;
    private JLabel lblAvaliacao;


    private Double memes = 0.0;
    private int i = 0;
    ArrayList notas = new ArrayList();

    public Notas_e_Media() {
    btnAdicionar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Double jorge = Double.valueOf(txtNota.getText());
            txtAreaNotas.append(jorge + "\n");
            memes = jorge + memes;
            i++;
        }
    });
    btnCalcularMedia.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Double media = memes / i;
            if (media >= 70) {
                lblAvaliacao.setText("Aprovado" + media);
            } else {
                lblAvaliacao.setText("Reprovado" + media);
            }
        }
    });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Notas_e_Media");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane((new Notas_e_Media()).Aplicativo_de_Notas);
        frame.setVisible(true);
        frame.pack();
    }

}
