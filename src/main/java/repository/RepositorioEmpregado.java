package repository;

import model.Empregado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RepositorioEmpregado {

    private Connection conexao;

    public RepositorioEmpregado(Connection conexao) {
        this.conexao = conexao;
    }

    //Salvar um empregado no banco de dados
    public void salvar(Empregado empregado) throws SQLException {

        //Criando comando de inserção
        String textoDoComando = "INSERT INTO empregado(matricula, nome, endereco, salario, coddep, cargo) " +
                "VALUES (?, ?, ?, ?, ?, ?);";

        //Preenchendo parâmetros do comando com os dados do objeto empregado
        PreparedStatement comando = conexao.prepareStatement(textoDoComando);

        comando.setInt(1, empregado.getMatricula());
        comando.setString(2, empregado.getNome());
        comando.setString(3, empregado.getEndereco());
        comando.setFloat(4, empregado.getSalario());
        comando.setInt(5, empregado.getCoddep());
        comando.setString(6, empregado.getCargo());

        //Executando comando
        comando.execute();
    }

    //Retornar lista de empregados salvos no banco
    public List<Empregado> recuperarEmpregados() throws SQLException {

        //Criando lista de retorno
        List<Empregado> empregados = new LinkedList<>();

        //Criando comando SELECT
        String textoDoComando = "SELECT matricula, nome, endereco, salario, coddep, cargo " +
                " FROM public.empregado;";

        PreparedStatement comando = conexao.prepareStatement(textoDoComando);

        //Executando comando e obtendo um result set com os dados
        ResultSet resultSet = comando.executeQuery();

        //Iterando por todas as tuplas retornadas pelo comando
        while(resultSet.next()) {

            //Criando novo empregado
            Empregado empregado = new Empregado();

            //Prenchendo objeto
            empregado.setMatricula(resultSet.getInt(1));
            empregado.setNome(resultSet.getString(2));
            empregado.setEndereco(resultSet.getString(3));
            empregado.setSalario(resultSet.getFloat(4));
            empregado.setCoddep(resultSet.getInt(5));
            empregado.setCargo(resultSet.getString(6));

            //Adicionando novo empregado à lista
            empregados.add(empregado);
        }

        //Retornando lista de empregados
        return empregados;
    }
}

