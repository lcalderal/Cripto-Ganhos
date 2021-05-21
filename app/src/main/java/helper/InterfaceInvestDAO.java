package helper;

import java.util.List;

import model.Investimento;
import model.InvestimentosItem;

public interface InterfaceInvestDAO {

    public boolean salvar(InvestimentosItem investimento);
    public boolean atualizar(InvestimentosItem investimento);
    public boolean deletar(InvestimentosItem investimento);
    public List<InvestimentosItem> listar();
}
