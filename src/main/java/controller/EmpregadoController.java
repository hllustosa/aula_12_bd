package controller;

import model.Empregado;
import repository.RepositorioEmpregado;

import java.util.List;

public class EmpregadoController {

    private RepositorioEmpregado repositorio;

    public EmpregadoController(RepositorioEmpregado repositorio) {
        this.repositorio = repositorio;
    }

    public boolean salvar(Empregado empregado) {
        try {
            repositorio.salvar(empregado);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Empregado> recuperar() {
        try {
            return repositorio.recuperarEmpregados();
        } catch (Exception e) {
            return null;
        }
    }
}
