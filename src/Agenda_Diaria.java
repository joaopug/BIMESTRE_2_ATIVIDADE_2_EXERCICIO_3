import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class Agenda_Diaria {
    private JPanel panelMain;
    private JSpinner spnData;
    private JTextField txtCompromisso;
    private JLabel lblComp;
    private JLabel lblHorario;
    private JTable tblCompromissos;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JSpinner spnHorario;
    private JLabel lblStatus;
    private JLabel lblDta;
    private JLabel lblDesc;
    private JLabel lblCompromissos;
    private JLabel lblHra;
    private JLabel lblData;

    private DefaultTableModel modeloDaTabela;

    private String compromisso = "";
    private String dataCompromisso = "";
    private String horarioCompromisso = "";

    private int linhaSelecionada = 0;

    public Agenda_Diaria() {
        modeloDaTabela = new DefaultTableModel(new Object[]{"Data", "Horário", "Compromisso"}, 0);
        tblCompromissos.setModel(modeloDaTabela);

        spnHorario.setModel(new SpinnerDateModel());
        spnHorario.setEditor(new JSpinner.DateEditor(spnHorario, "HH:mm"));

        spnData.setModel(new SpinnerDateModel());
        spnData.setEditor(new JSpinner.DateEditor(spnData, "dd/MM/yyyy"));

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compromisso = txtCompromisso.getText();
                dataCompromisso = new SimpleDateFormat("dd/MM/yyyy").format(spnData.getValue());
                horarioCompromisso = new SimpleDateFormat("HH:mm").format(spnHorario.getValue());

                if (!compromisso.equals("")) {
                    modeloDaTabela.addRow(new Object[]{dataCompromisso, horarioCompromisso, compromisso});
                    txtCompromisso.setText("");
                    lblStatus.setText("Compromisso adicionado!");
                } else {
                    lblStatus.setText("Preencha o campo compromisso!");
                }
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linhaSelecionada = tblCompromissos.getSelectedRow();
                if (linhaSelecionada != -1) {
                    modeloDaTabela.removeRow(linhaSelecionada);
                    lblStatus.setText("Compromisso removido!");
                } else {
                    lblStatus.setText("Selecione um compromisso para remover!");
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diaria");
        frame.setContentPane(new Agenda_Diaria().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}