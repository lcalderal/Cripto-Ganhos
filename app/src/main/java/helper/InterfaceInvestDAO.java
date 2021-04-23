package helper;

import java.util.List;

import model.InvestimentosItem;

public interface InterfaceInvestDAO {

    public boolean salvar(InvestimentosItem investimentosItem);
    public boolean atualizar(InvestimentosItem investimentosItem);
    public boolean deletar(InvestimentosItem investimentosItem);
    public List<InvestimentosItem> listar();
}
