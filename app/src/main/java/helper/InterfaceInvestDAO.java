package helper;

import java.util.List;

import model.Investimento;
import model.InvestimentosItem;

public interface InterfaceInvestDAO {

    public boolean salvar(Investimento investimento);
    public boolean atualizar(Investimento investimento);
    public boolean deletar(Investimento investimento);
    public List<Investimento> listar();
}
