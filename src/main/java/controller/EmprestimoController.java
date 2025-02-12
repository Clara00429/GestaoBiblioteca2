package controller;

import model.EmprestimoModel;
import repository.EmprestimoRepository;
import java.util.List;
import java.util.Date;

public class EmprestimoController {
    private EmprestimoRepository emprestimoR = new EmprestimoRepository();

//nao utilizados, implementados direto na classe
    public List<EmprestimoModel> buscarEmprestimos() {
        return emprestimoR.buscarTodosEmprestimos();
    }

    public EmprestimoModel buscarEmprestimoPorDataInicio(Date dataInicio) {
        return emprestimoR.buscarEmprestimo(dataInicio);
    }

    public String removerEmprestimo(Date dataInicio) {
        return emprestimoR.removerEmprestimo(dataInicio);
    }
}