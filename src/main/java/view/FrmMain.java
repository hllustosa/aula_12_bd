package view;

import controller.EmpregadoController;
import model.Empregado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrmMain {
    private JPanel PnMain;
    private JTextField txtMatricula;
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtSalario;
    private JTextField txtDepartamento;
    private JTextField txtCargo;
    private JButton btnSalvar;
    private JButton btnListar;
    private JLabel lblMatricula;
    private JLabel lblNome;
    private JLabel lblEndereco;
    private JLabel lblSalario;
    private JLabel lblDepartamento;
    private JLabel lblCargo;

    private EmpregadoController controller;

    public FrmMain(EmpregadoController controller) {
        this.controller = controller;
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listar();
            }
        });
    }

    private Empregado criar() {
        Empregado empregado = new Empregado();
        empregado.setMatricula(Integer.parseInt(txtMatricula.getText()));
        empregado.setNome((txtNome.getText()));
        empregado.setEndereco(txtEndereco.getText());
        empregado.setSalario(Float.parseFloat(txtSalario.getText()));
        empregado.setCoddep(Integer.parseInt(txtDepartamento.getText()));
        empregado.setCargo(txtCargo.getText());
        return empregado;
    }

    private void salvar() {
        try {
            if (this.controller.salvar(criar())) {
                JOptionPane.showMessageDialog(null, "Empregado salvo com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao salvar empregado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar empregado");
        }
    }

    private void listar() {

        List<Empregado> empregados = this.controller.recuperar();

        if(empregados == null) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar empregados empregado");
            return;
        }

        String txtEmpregados = "Empregado\n";

        for (Empregado empregado : empregados) {
            txtEmpregados += empregado.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, txtEmpregados);
    }

    public JPanel getPnMain() {
        return PnMain;
    }
}
