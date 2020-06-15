import controller.EmpregadoController;
import repository.RepositorioEmpregado;
import view.FrmMain;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        //Definindo a string de conexão: IP do servidor:porta/[nome do banco de dados]
        String stringDeConexao = "jdbc:postgresql://127.0.0.1:5432/Empresa";

        //Criando conexão com base na string de conexão, no usuário e a senha do banco de dados
        return DriverManager.getConnection(stringDeConexao, "postgres", "postgres");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        RepositorioEmpregado repositorioEmpregado = new RepositorioEmpregado(obterConexao());
        EmpregadoController controller = new EmpregadoController(repositorioEmpregado);

        JFrame frame = new JFrame();
        frame.setContentPane(new FrmMain(controller).getPnMain());
        frame.pack();
        frame.setResizable(false);
        frame.setSize(400, 420);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Cadastro de Empregado");
        frame.setVisible(true);
    }
}